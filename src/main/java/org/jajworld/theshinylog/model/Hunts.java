package org.jajworld.theshinylog.model;

import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Hunts {

	@Id
	private Integer hid;
	private Integer pid;
	private Integer pokenum;
	private Integer encounters;
	private Integer gen;
	private String notes;
	private Blob pic;
	
	public Integer getHid() {
		return hid;
	}
	public void setHid(Integer hid) {
		this.hid = hid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getPokenum() {
		return pokenum;
	}
	public void setPokenum(Integer pokenum) {
		this.pokenum = pokenum;
	}
	public Integer getEncounters() {
		return encounters;
	}
	public void setEncounters(Integer encounters) {
		this.encounters = encounters;
	}
	public Integer getGen() {
		return gen;
	}
	public void setGen(Integer gen) {
		this.gen = gen;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes() {
		this.notes = notes;
	}
	public Blob getPic() {
		return this.pic;
	}
	public void setImage(Blob pic) {
		this.pic = pic;
	}
}
