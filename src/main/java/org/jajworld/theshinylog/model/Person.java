package org.jajworld.theshinylog.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
	
	@Id
	private Integer pid;
	private String pname;
	private String pcode;
	private Boolean rank;
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public Boolean getRank() {
		return rank;
	}
	public void setRank(Boolean rank) {
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return pname + " " + pcode;
	}

}
