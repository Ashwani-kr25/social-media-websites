package com.example.SocialMediaProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SocialMediaProject.Model.comment;
import com.example.SocialMediaProject.Model.uploadtable;
import com.example.SocialMediaProject.Model.usertable;
import com.example.SocialMediaProject.Repository.commentrepo;
import com.example.SocialMediaProject.Repository.uploadrepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class commentcontroller {
@Autowired
private commentrepo repo;
@Autowired
private uploadrepo uploadrep;

	@PostMapping("/addcommentus")
	public String addcomment(@RequestParam("commenttext") String comment,@RequestParam("postid") long id,  HttpSession session) {
     usertable user =(usertable)session.getAttribute("loginuser");
     uploadtable upload =uploadrep.findById(id).orElse(null);

     comment com=new comment();
     com.setUsername(user.getUsername());
     com.setPost(upload);
     com.setComment(comment);
     repo.save(com);

	return "redirect:/user";

	}

@GetMapping("/addcomment")
public String addcomments() {

	return "user";
}

@PostMapping("/addcommentpr")
public String addcomments(@RequestParam("commenttext") String comment,@RequestParam("postid") long id,  HttpSession session) {
 usertable user =(usertable)session.getAttribute("loginuser");
 uploadtable upload =uploadrep.findById(id).orElse(null);

 comment com=new comment();
 com.setUsername(user.getUsername());
 com.setPost(upload);
 com.setComment(comment);
 repo.save(com);

return "redirect:/profile";

}
}