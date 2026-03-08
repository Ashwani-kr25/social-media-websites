package com.example.SocialMediaProject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class comment {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@ManyToOne
@JoinColumn(name="post_id")
private uploadtable post;

private String username;
private String comment;
public String getComment() {
	return comment;
}

public void setComment(String comment) {
	this.comment = comment;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public uploadtable getPost() {
	return post;
}

public void setPost(uploadtable post) {
	this.post = post;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

}
