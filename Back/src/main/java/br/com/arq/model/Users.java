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

	public String toString() {
		String var10000 = String.valueOf(this.id);
		return "Student [id=" + var10000 + ", name=" + this.name + ", email=" + this.email + ", telefone=" + this.telefone + "]";
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
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String criptografia(String password) throws Exception {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] messageDigest = md5.digest(password.getBytes());
		StringBuilder sb = new StringBuilder();
		byte[] var8 = messageDigest;
		int var7 = messageDigest.length;

		for (int var6 = 0; var6 < var7; ++var6) {
			byte b = var8[var6];
			sb.append("%02x".formatted(b));
		}

		return sb.toString();
	}
}
