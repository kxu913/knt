package com.ny6design.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page<T> {
	private int pageNo = 1;
	private int pageSize = 5;
	private int totalRecord;
	private int totalPage;
	private int offset;
	private List<T> results;
	private Map<String, Object> params = new HashMap<String, Object>();

	/**
	 * 
	 * @param totalRecord
	 * @param pageSize
	 * @param pageNo
	 */
	public Page(int pageSize,int pageNo) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		setOffset(pageNo * pageSize);
		int totalPage = 1;
		if (totalRecord % pageSize == 0) {
			totalPage = totalRecord / pageSize;
		} else {
			totalPage = totalRecord / pageSize + 1;
		}
		this.setTotalPage(totalPage);
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPageNo() {
		return pageNo;
	}

//	public void setPageNo(int pageNo) {
//		this.pageNo = pageNo;
//		setOffset(pageNo * pageSize);
//	}

	public int getPageSize() {
		return pageSize;
	}

//	public void setPageSize(int pageSize) {
//		this.pageSize = pageSize;
//	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		int totalPage = 1;
		if (totalRecord % pageSize == 0) {
			totalPage = totalRecord / pageSize;
		} else {
			totalPage = totalRecord / pageSize + 1;
		}
		this.setTotalPage(totalPage);
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageSize=" + pageSize
				+ ", totalRecord=" + totalRecord + ", totalPage=" + totalPage
				+ ", offset=" + offset + ", results=" + results + ", params="
				+ params + "]";
	}

	
}
