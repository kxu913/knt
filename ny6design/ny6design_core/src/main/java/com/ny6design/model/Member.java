package com.ny6design.model;

import java.io.Serializable;

public class Member implements Serializable {

    private static final long serialVersionUID = -3138863613422043759L;

    private String sabun = "";

    private String registno = "";

	public String getSabun() {
		return sabun;
	}

	public void setSabun(String sabun) {
		this.sabun = sabun;
	}

	public String getRegistno() {
		return registno;
	}

	public void setRegistno(String registno) {
		this.registno = registno;
	}

}
