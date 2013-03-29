package com.stefan.spitter;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.stefan.spittle.Spittle;

@SuppressWarnings("serial")
@Entity
@Table (name = "spitters")
public class Spitter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "spitter_id")
	private long id;
	
	@Column(name = "spitter_name")
	private String name;

	@OneToMany
	private List<Spittle> spittles;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Spittle> getSpittles() {
		return spittles;
	}
	public void setSpittles(List<Spittle> spittles) {
		this.spittles = spittles;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
}
