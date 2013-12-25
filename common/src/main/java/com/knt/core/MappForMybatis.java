package com.knt.core;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * The Core class for get Mapper
 * 
 * @author kxu
 * 
 */
@Repository("mapperForMybatis")
public class MappForMybatis extends SqlSessionDaoSupport {
	/**
	 * get an instance of mapper by class
	 * 
	 * @param <T>
	 * @param clazz
	 * @return the Mapper
	 */
	public <T> T getMapper(Class<T> clazz) {
		SqlSession sqlSession = null;
		try {
			sqlSession = this.getSqlSession();
			return sqlSession.getMapper(clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
