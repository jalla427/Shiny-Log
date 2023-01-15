package org.jajworld.theshinylog.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FormattedHunts {

	@Id
	private int hid;
	private String pokename;
	private Integer gen;
	private String hunter;
	private Integer encounters;
	private String notes;
	
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getPokename() {
		return pokename;
	}
	public void setPokename(String pokename) {
		this.pokename = pokename;
	}
	public Integer getGen() {
		return gen;
	}
	public void setGen(Integer gen) {
		this.gen = gen;
	}
	public String getHunter() {
		return hunter;
	}
	public void setHunter(String hunter) {
		this.hunter = hunter;
	}
	public Integer getEncounters() {
		return encounters;
	}
	public void setEncounters(Integer encounters) {
		this.encounters = encounters;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
}
