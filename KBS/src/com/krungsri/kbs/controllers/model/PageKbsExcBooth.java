package com.krungsri.kbs.controllers.model;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class PageKbsExcBooth {
	private String local;
	private List<KbsExcBoothForm> rows;		
	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public List<KbsExcBoothForm> getRows() {
		return rows;
	}

	public void setRows(List<KbsExcBoothForm> rows) {
		this.rows = rows;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
