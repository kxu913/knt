package com.ny6design.mybatis;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.proxy.jdbc.StatementProxyImpl;
import com.mysql.jdbc.PreparedStatement;

@Intercepts({ @Signature(method = "prepare", type = StatementHandler.class, args = { Connection.class }) })
public class PageInterceptor implements Interceptor {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	private String databaseType;

	public String getDatabaseType() {
		return databaseType;
	}

	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation
				.getTarget();
		BoundSql boundSql = statementHandler.getBoundSql();
		Object args = boundSql.getParameterObject();
		Page page = this.getPageFromArgs(args);
		MetaObject metaStatementHandler = MetaObject
				.forObject(statementHandler);
		RowBounds rowBounds = (RowBounds) metaStatementHandler
				.getValue("delegate.rowBounds");
		if (rowBounds == null || page == null) {
			return invocation.proceed();

		}
		Dialect dialect = createDialect();
		String originalSql = (String) metaStatementHandler
				.getValue("delegate.boundSql.sql");
		if (page != null) {
			int total = getTotal(invocation, metaStatementHandler, dialect,
					originalSql, args);
			page.setTotalRecord(total);
			if (log.isDebugEnabled()) {
				log.debug("total : " + total);
			}
			metaStatementHandler.setValue(
					"delegate.boundSql.sql",
					dialect.getLimitString(originalSql, page.getOffset(),
							page.getPageSize()));
			metaStatementHandler.setValue("delegate.rowBounds.offset",
					RowBounds.NO_ROW_OFFSET);
			metaStatementHandler.setValue("delegate.rowBounds.limit",
					RowBounds.NO_ROW_LIMIT);
		}
		if (log.isDebugEnabled()) {

			log.debug("Paging SQL : " + boundSql.getSql());

		}

		return invocation.proceed();
	}

	private int getTotal(Invocation invocation,
			MetaObject metaStatementHandler, Dialect dialect,
			String originalSql, Object args) throws InvocationTargetException,
			IllegalAccessException, SQLException {
		java.sql.Statement statement = (java.sql.Statement) invocation
				.proceed();
		ResultSet rs = statement.executeQuery(dialect.getCountString(
				originalSql, args));
		while (rs.next()) {
			return rs.getInt(1);
		}
		throw new SQLException("Can't get total");
	}

	private Page getPageFromArgs(Object args) {
		if (args instanceof Page) {
			return (Page) args;
		}

		if (args instanceof Map) {
			Map<String, Object> map = (Map<String, Object>) args;
			for (Entry<String, Object> entry : map.entrySet()) {
				if (entry.getValue() instanceof Page) {
					return (Page) entry.getValue();
				}
			}
		}
		return null;
	}

	private Dialect createDialect() {

		Dialect dialect = null;
		if (databaseType.equalsIgnoreCase("mysql")) {
			dialect = new MySQLDialect();
		}
		return dialect;
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {

	}

}
