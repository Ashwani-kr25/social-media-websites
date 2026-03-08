package com.example.SocialMediaProject.Model;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class usertable {

	@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;

	private String name;
	private String mobile;
	private String email;
	private String primage;
	@Column(unique=true, nullable=false)
	private String username;
	
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<uploadtable> uploads;

	public List<uploadtable> getUploads() {
		return uploads;
	}

	public void setUploads(List<uploadtable> uploads) {
		this.uploads = uploads;
	}


	private String dob;
	private String password;

	public usertable() {
		super();
	}

	public usertable(String name, String mobile, String email, String primage, String username, String dob,
			String password) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.primage = primage;
		this.username = username;
		this.dob = dob;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrimage() {
		return primage;
	}

	public void setPrimage(String primage) {
		this.primage = primage;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



}
