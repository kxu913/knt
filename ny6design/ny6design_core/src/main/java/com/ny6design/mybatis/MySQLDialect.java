package com.ny6design.mybatis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

public class MySQLDialect implements Dialect {

	protected static final String SQL_END_DELIMITER = ";";
	private static final String SQL_COUNT = "SELECT COUNT(1) FROM";
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public String getLimitString(String sql, boolean hasOffset) {
		return new StringBuffer(sql.length() + 20).append(trim(sql))
				.append(hasOffset ? " limit ?,?" : " limit ?")
				.append(SQL_END_DELIMITER).toString();
	}

	public String getLimitString(String sql, int offset, int limit) {
		sql = trim(sql);
		StringBuffer sb = new StringBuffer(sql.length() + 20);
		sb.append(sql);
		if (offset > 0) {
			sb.append(" limit ").append(offset).append(',').append(limit)
					.append(SQL_END_DELIMITER);
		} else {
			sb.append(" limit ").append(limit).append(SQL_END_DELIMITER);
		}
		return sb.toString();
	}

	public boolean supportsLimit() {
		return true;
	}

	private String trim(String sql) {
		sql = sql.trim();
		if (sql.endsWith(SQL_END_DELIMITER)) {
			sql = sql.substring(0,
					sql.length() - 1 - SQL_END_DELIMITER.length());
		}
		return sql;
	}

	public boolean supportsLimitOffset() {
		return true;
	}

	@Override
	public String getCountString(String sql, Object args) {
		sql = trim(sql).toUpperCase();
		StringBuffer sb = new StringBuffer(SQL_COUNT);
		// sb.append(sql.substring(sql.indexOf("FROM")));
		int fromIndex = sql.indexOf("FROM") + 4;
		if (args instanceof Page) {
			sb.append(sql.substring(fromIndex));
			return sb.toString();
		}
		if (args instanceof Map) {
			Map<String, Object> map = (Map<String, Object>) args;
			String splits[] = sql.substring(fromIndex).split("\\?");
			int i = 0;
			boolean oneArg = map.size() <= 2;
			for (Entry<String, Object> entry : map.entrySet()) {
				// Map<String, Object> params = (Map<String, Object>)
				// entry.getValue();
				Object arg = entry.getValue();
				String argKey = entry.getKey();
				if (argKey.indexOf("param") >= 0) {
					if (arg instanceof Page) {
						if (oneArg) {
							sb.append(sql.substring(fromIndex));
							return sb.toString();
						}
						continue;
					}
					sb.append(splits[i]+"'");
					i++;
					if (arg instanceof Date) {
						Date date = (Date) arg;
						sb.append(dateFormat.format(date));
					} else {
						sb.append(arg.toString());
					}
					sb.append("'");
				}

				// sb.append(splits[i]);

			}
		}
		return sb.toString();

	}

}