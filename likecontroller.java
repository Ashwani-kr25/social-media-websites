package com.example.SocialMediaProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SocialMediaProject.Model.liked;
import com.example.SocialMediaProject.Model.uploadtable;
import com.example.SocialMediaProject.Model.usertable;
import com.example.SocialMediaProject.Repository.likerepo;
import com.example.SocialMediaProject.Repository.uploadrepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class likecontroller {
	@Autowired
	private uploadrepo repo;

	@Autowired
	private likerepo likedrepo;

	@GetMapping("/likepost")
	public String  like( ) {
		return "redirect:/user";
	}

	@PostMapping("/likepostus")
	public String likepost(HttpSession session,@RequestParam("postid") long id) {
		usertable user=(usertable)session.getAttribute("loginuser");

  uploadtable upload =repo.findById(id).orElse(null);
  liked check=likedrepo.findByUsernameAndPost(user.getUsername(), upload);
  if(check!=null) {

	  return "redirect:/user";
  }
		liked like=new liked();
		like.setUsername(user.getUsername());
		like.setPost(upload);
		likedrepo.save(like);

return"redirect:/user";

	}



	@PostMapping("/likepostpr")
	public String likeposts(HttpSession session,@RequestParam("postid") long id) {
		usertable user=(usertable)session.getAttribute("loginuser");

  uploadtable upload =repo.findById(id).orElse(null);
  liked check=likedrepo.findByUsernameAndPost(user.getUsername(), upload);
  if(check!=null) {

	  return "redirect:/profile";
  }
		liked like=new liked();
		like.setUsername(user.getUsername());
		like.setPost(upload);
		likedrepo.save(like);

return"redirect:/profile";

	}


}
