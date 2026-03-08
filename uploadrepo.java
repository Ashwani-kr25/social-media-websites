package com.example.SocialMediaProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SocialMediaProject.Model.uploadtable;
import com.example.SocialMediaProject.Model.usertable;

public interface uploadrepo extends JpaRepository<uploadtable, Long>{
    List<uploadtable> findByUser(usertable user);
    int countByUser(usertable user);

}
