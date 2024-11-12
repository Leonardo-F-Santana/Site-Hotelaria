package br.com.arq.model;

import java.security.MessageDigest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String password;
	@Column(unique=true)
	private String email;
	@Column(unique = true)
	private String telefone;
	private Integer admin;
	@Override

	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", telefone=" + telefone + ", admin=" + admin + "]";
	}

	public Users() {
	}

	public Users(Integer id, String name, String email, String telefone, Integer admin) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.telefone = telefone;
		this.admin = admin;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getAdmin() {
		return admin;
	}
	public void setAdmin(Integer admin) {
		this.admin = admin;
	}
}
