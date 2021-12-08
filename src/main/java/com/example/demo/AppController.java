package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("signup")
	public String signupForm(Model model) {
		model.addAttribute("user", new User());
	     
	    return "signup_form";
	}
	
	@PostMapping("/add_user")
	public String processRegister(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
	    userRepo.save(user);
	     
	    return "register_success";
	}
	
	@GetMapping("list_books")
	public String viewBooksList() {
	    return "booklist";
	}
}
