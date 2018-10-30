package com.sample.domain.order;

import java.io.Serializable;

public class FullOrderIndexer implements Serializable {
	private static final long serialVersionUID = -1352996595383291586L;

	private String _id;
	private String statusValue;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

}
