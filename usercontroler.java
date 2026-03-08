package com.example.SocialMediaProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.SocialMediaProject.Model.uploadtable;
import com.example.SocialMediaProject.Model.usertable;
import com.example.SocialMediaProject.Repository.commentrepo;
import com.example.SocialMediaProject.Repository.likerepo;
import com.example.SocialMediaProject.Repository.uploadrepo;
import com.example.SocialMediaProject.Repository.userrepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class usercontroler {

	@Autowired
	private uploadrepo repo;
	@Autowired
	private likerepo likerepo;

	@Autowired
	private commentrepo commentrepo;
 @Autowired
 private userrepository userrepo;
	@GetMapping("/user")
    public String user(HttpSession session, Model model) {
        usertable user = (usertable) session.getAttribute("loginuser");
        List<uploadtable> allposts = repo.findAll();

        if (user != null) {
            for(uploadtable post: allposts) {

                long likeCount = likerepo.countBypost_id(post.getId());
                post.setTotal_likes(likeCount);
               long commentcount=commentrepo.countBypost_id(post.getId());
               post.setTotal_comments(commentcount);
                repo.save(post);

            }
            model.addAttribute("username", user.getUsername());
            model.addAttribute("allposts",allposts);
            return "user";
        } else {
            return "redirect:/";
        }
    }



	@GetMapping("/profile")
	public String profile(HttpSession session, Model model) {
	    usertable user = (usertable) session.getAttribute("loginuser");
	    if (user == null) {
	        return "redirect:/";
	    }

	    List<uploadtable> uploads = repo.findByUser(user);
	    for (uploadtable post : uploads) {
	        long likeCount = likerepo.countBypost_id(post.getId());
	        post.setTotal_likes(likeCount);

	        long commentCount = commentrepo.countBypost_id(post.getId());
	        post.setTotal_comments(commentCount);

	        repo.save(post);
	    }

	    int postcount = repo.countByUser(user);

	    model.addAttribute("username", user.getUsername());
	    model.addAttribute("primage", user.getPrimage());
	    model.addAttribute("postcount", postcount);
	    model.addAttribute("uploads", uploads);
	    model.addAttribute("name", user.getName());
	    model.addAttribute("dob", user.getDob());

	    return "profile"; // Correct view return
	}

   @GetMapping("/delete")
	   public String delete(HttpSession session) {
		   usertable user=(usertable) session.getAttribute("loginuser");
		   long id=user.getId();
		   userrepo.deleteById(id);
		   return "redirect:/";
		   }
   
@GetMapping("/logout")
public String logout(HttpSession session) {
	session.invalidate();
	return "redirect:/";
}


}
