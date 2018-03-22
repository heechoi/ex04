package com.dgit.domain;

import java.util.Date;

public class ProjectVO {
	private int pno;
	private String name;
	private String content;
	private Date startdate;
	private Date enddate;
	private String state;
	
	public ProjectVO() {}
	
	
	public int getPno() {
		return pno;
	}


	public void setPno(int pno) {
		this.pno = pno;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Override
	public String toString() {
		return String.format("ProjectVO [pno=%s, name=%s, content=%s, startdate=%s, enddate=%s, state=%s]", pno, name,
				content, startdate, enddate, state);
	}


	
	
	
}
