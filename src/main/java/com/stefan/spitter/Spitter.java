package com.stefan.spitter;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.stefan.spittle.Spittle;

@SuppressWarnings("serial")
@Entity
@Table (name = "spitters")
public class Spitter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "spitter_id")
	private long id;
	
	@Size(min=3, max=20, message="Username must be between 3 and 20 characters long.")
	@Pattern(regexp="^[a-zA-Z0-9]+$", message="Username must be alphanumeric with no spaces")
	@Column(name = "spitter_name")
	private String name;

	@Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message="Invalid email address.")
	@Column(name = "spitter_email")
	private String email;
	
	@Size(min=6, max=20, message="The password must be at least 6 characters long.")
	@Column(name = "spitter_password")
	private String password;
	
	@Column(name = "spitter_update_by_email")
	private boolean updateByEmail;

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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isUpdateByEmail() {
		return updateByEmail;
	}
	
	public void setUpdateByEmail(boolean updateByEmail) {
		this.updateByEmail = updateByEmail;
	}
}
