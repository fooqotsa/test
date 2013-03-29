package com.stefan.spittle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.stefan.spitter.Spitter;

@SuppressWarnings("serial")
@Entity
@Table (name = "spittles")
public class Spittle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "spittle_id")
	private long id;
	
	@Column(name = "spittle_value")
	private String value;
	
	@ManyToOne
	private Spitter spitter;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Spitter getSpitter() {
		return spitter;
	}
	public void setSpitter(Spitter spitter) {
		this.spitter = spitter;
	}
}
