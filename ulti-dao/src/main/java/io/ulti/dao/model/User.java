package io.ulti.dao.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="APP_USER")
public class User {

	@Id
	@Column(name="ID")
	private long id;

	@Column(name="NAME")
	private String name;
	
	@ManyToMany
	@JoinTable(name = "CN_USERS_ROLES", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"))
	private List<Role> roles;

}
