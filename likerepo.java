package com.example.SocialMediaProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SocialMediaProject.Model.liked;
import com.example.SocialMediaProject.Model.uploadtable;

@Repository
public interface likerepo extends JpaRepository<liked, Long> {
	liked findByUsernameAndPost(String username,uploadtable upload);
	long countBypost_id(long post_id);
	}
