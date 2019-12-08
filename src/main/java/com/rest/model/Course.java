package com.rest.model;

public class Course {
	private String cId;
	private String cName;
	
	
	public Course(String cId, String cName) {
		super();
		this.cId = cId;
		this.cName = cName;
	}
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	
	

}
