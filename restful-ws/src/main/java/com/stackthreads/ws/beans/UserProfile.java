package com.stackthreads.ws.beans;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserProfile {

	@JsonIgnore
	private int id;
	@Size(min=2,message="user name has to be atleast of length 2!")
	private String name;
	@Past
	private Date dob;

	public UserProfile() {
		super();
	}

	public UserProfile(int id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserProfile other = (UserProfile) obj;
		if (id != other.id)
			return false;
		return true;
	}
	

}
