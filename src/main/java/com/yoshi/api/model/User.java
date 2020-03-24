package com.yoshi.api.model;

import javax.persistence.*;

import org.dom4j.tree.AbstractEntity;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@NotBlank
	@Column(unique = true)
	private String username;
	
	@NotBlank
	@JsonIgnore
	private String password;
	
	@NotBlank
	private String email;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="user_role",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="role_id")
	)
	private List<Role> roles;
	

	public User() {
	}

	public User(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}
	public User(User user) {
		super();
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.roles = user.getRoles();
		this.id = user.getId();
	}
	public User(String username, String email, String password, List<Role> roles) {
		super();
		this.username = username;
		this.email = email;
		this.roles = roles;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
