package org.jajworld.theshinylog.model;

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
	private byte[] pic;
	
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
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] pic) {
		this.pic = pic;
	}
}
