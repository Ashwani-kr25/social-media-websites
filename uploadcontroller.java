package com.example.SocialMediaProject.Controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.SocialMediaProject.Model.uploadtable;
import com.example.SocialMediaProject.Model.usertable;
import com.example.SocialMediaProject.Repository.uploadrepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class uploadcontroller {
	@Autowired
	private uploadrepo repo;

	@GetMapping("/post")
	public String post() {
		return "post";
	}


	@PostMapping("/post")
	public String post(@RequestParam String caption ,@RequestParam("file") MultipartFile file, HttpSession session) throws IOException
	{
        String projectDir = System.getProperty("user.dir");

		String uploaddir=projectDir+"/uploads/";
		 File directory = new File(uploaddir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

		String filepath=uploaddir+ file.getOriginalFilename();
		file.transferTo(new File(filepath));

		usertable user = (usertable) session.getAttribute("loginuser");

		uploadtable upload= new uploadtable();
		upload.setCaption(caption);
		upload.setFilepath(file.getOriginalFilename());
		upload.setUser(user);
		repo.save(upload);
		return "redirect:/post";

	}

}