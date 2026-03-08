package com.example.SocialMediaProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SocialMediaProject.Model.comment;

@Repository
public interface commentrepo extends JpaRepository<comment, Long> {
	long countBypost_id(long post_id);

}
