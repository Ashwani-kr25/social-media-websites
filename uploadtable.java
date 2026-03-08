package com.example.SocialMediaProject.Model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class uploadtable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private  String caption;
private long total_likes;
private long total_comments;

@Column( updatable=false)
@CreationTimestamp
private LocalDateTime created_at;


public LocalDateTime getCreated_at() {
	return created_at;
}

public void setCreated_at(LocalDateTime createdAt) {
	this.created_at = created_at;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getCaption() {
	return caption;
}

public void setCaption(String caption) {
	this.caption = caption;
}

public long getTotal_likes() {
	return total_likes;
}

public void setTotal_likes(long total_likes) {
	this.total_likes = total_likes;
}

public long getTotal_comments() {
	return total_comments;
}

public void setTotal_comments(long total_comments) {
	this.total_comments = total_comments;
}

public String getFilepath() {
	return filepath;
}

public void setFilepath(String filepath) {
	this.filepath = filepath;
}

public usertable getUser() {
	return user;
}

public void setUser(usertable user) {
	this.user = user;
}

public List<liked> getLikes() {
	return likes;
}

public void setLikes(List<liked> likes) {
	this.likes = likes;
}

public List<comment> getComments() {
	return comments;
}

public void setComments(List<comment> comments) {
	this.comments = comments;
}

private String filepath;

@ManyToOne
@JoinColumn(name = "user_id")  // foreign key column
private usertable user;


@OneToMany(mappedBy="post", cascade=CascadeType.ALL)
private List<liked> likes;

@OneToMany(mappedBy="post",cascade=CascadeType.ALL)
private List<comment> comments;







}
