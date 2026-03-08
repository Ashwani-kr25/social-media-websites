package com.example.SocialMediaProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SocialMediaProject.Model.usertable;

public interface userrepository extends JpaRepository<usertable, Long> {
    usertable findByUsername(String username);

}
