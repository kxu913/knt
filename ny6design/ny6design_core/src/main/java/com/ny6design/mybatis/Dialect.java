package com.ny6design.mybatis;

public interface Dialect {
	public enum Type {
		mysql, oracle
	}

	public boolean supportsLimit();

	public String getLimitString(String sql, boolean hasOffset);

	public String getLimitString(String sql, int offset, int limit);

	public boolean supportsLimitOffset();
}
