package com.ayantsoft.springbootdeploy.springbootdeploy.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table
public class Roles implements Serializable{
			
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long role_id;
	
	@Column(name="role")
	private String user_role;
	
	@ManyToMany(fetch = FetchType.EAGER,
			 cascade =  CascadeType.ALL,
            mappedBy = "roles")
	@JsonIgnore
    private Set<User> users = new HashSet<>();

	//getter and setter
	
	
	

	public String getUser_role() {
		return user_role;
	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	
}
	
