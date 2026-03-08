package com.example.SocialMediaProject.Controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.SocialMediaProject.Model.usertable;
import com.example.SocialMediaProject.Repository.userrepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class homecontroller {
	@Autowired
	private userrepository repo;

	@GetMapping("/")
public String home() {
	return "home";
}
	@GetMapping("/about")
public String about() {
	return "about";
}
	@GetMapping("/contact")
public String contact() {
	return "contact";
}

	@GetMapping("/signup")
public String signup() {
	return "signup";
}
	@PostMapping("/signup")
	public String adduser(@ModelAttribute usertable user, @RequestParam("file") MultipartFile file,
	                      RedirectAttributes redirect) throws IOException {

	    String projectDir = System.getProperty("user.dir");
	    String uploaddir = projectDir + "/uploads/";
	    File directory = new File(uploaddir);
	    if (!directory.exists()) {
	        directory.mkdirs();
	    }

	    String filepath = uploaddir + file.getOriginalFilename();
	    file.transferTo(new File(filepath));

	    user.setPrimage(file.getOriginalFilename());

	    try {
	        repo.save(user);
	        return "redirect:/";
	    } catch (Exception e) {
	        if (e.getCause() != null) {
	            redirect.addFlashAttribute("message", "Username already exists!");
		       

	        }
	        return "redirect:/signup";
	    }
	}

	@PostMapping("/login")

	public String login(@RequestParam String username , @RequestParam String password ,HttpSession session,RedirectAttributes redirectattribute) {
		usertable user =repo.findByUsername(username);
		if(user!=null && user.getPassword().equals(password)) {
			session.setAttribute("loginuser", user);
			return "redirect:/user";
		}
		else {
			redirectattribute.addFlashAttribute("message","Login Failed!");
			return "redirect:/";
		}
	}


}
