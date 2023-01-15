package org.jajworld.theshinylog.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Pokemon {

	@Id
	private Integer pokenum;
	private String pokename;
	
	public Integer getPokenum() {
		return pokenum;
	}
	public void setPokenum(Integer pokenum) {
		this.pokenum = pokenum;
	}
	public String getPokename() {
		return pokename;
	}
	public void setPokename(String pokename) {
		this.pokename = pokename;
	}
	@Override
	public String toString() {
		return "Pokemon [pokenum=" + pokenum + ", pokename=" + pokename + "]";
	}
}

