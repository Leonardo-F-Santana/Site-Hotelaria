// Source code is decompiled from a .class file using FernFlower decompiler.
package br.com.arq.model;

import java.security.MessageDigest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuarios")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String password;
	@Column(unique = true)
	private String email;

	@Column(unique = true)
	private String telefone;

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", telefone=" + telefone + "]";
	}

	public Users() {
	}

	public Users(Integer id, String name, String email, String telefone) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.telefone = telefone;
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

	public String criptografia(String password) throws Exception {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] messageDigest = md5.digest(password.getBytes());
		StringBuilder sb = new StringBuilder();
		for(byte b: messageDigest) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}
}
