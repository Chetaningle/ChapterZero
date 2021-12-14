package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
	@Autowired
	private UserRepository userRepo;
	@Autowired BookRepository bookRepo;	//Repository to the books DB
	@Autowired FavRepository favRepo;	//Repository to the Favorites DB
	List<Favorites> fav;
	String searchInput = "";
	
	@GetMapping("")
	public String viewHomePage() {
		this.searchInput = "";
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
	public String viewBooksList(Model model) {
		int userId = CustomUserDetailsService.cache.get("user");	// getting the userid from cache
		fav = favRepo.findByUserid(userId);	//getting all the favorites books
		if(searchInput == "")
			searchBookInput(model, "");
		else
			searchBookInput(model, searchInput);
		model.addAttribute("searchInput", searchInput);
	    return "booklist";
	}

	@GetMapping("/searchBooks")
    public String searchBookInput(Model model, @RequestParam("searchBookInput") String searchInput)
    {
		this.searchInput = searchInput;
        List<Book> book = bookRepo.findByAuthorNameContainsOrBookNameContainsOrPublisherContains(searchInput, searchInput, searchInput);
        for(Book b: book) {	// a little inefficient way of finding the favorites books from the search list
        	for(Favorites f: fav) {
        		if(b.bookid == f.bookid) {
        			b.setFavorite(true);
        		}
        	}
        }
        model.addAttribute("book", book);
        return "booklist";
    }
	
	@Transactional
	@PostMapping("/updateFavorites")
	public String updateFavorite(@ModelAttribute(value="book1") Book book1, Model model) {
		if(book1.favorite == true) {
			favRepo.removeByUseridAndBookid(CustomUserDetailsService.cache.get("user"), book1.bookid);
		} else {
			Favorites favUpdate = new Favorites();
		     favUpdate.setBookid(book1.bookid);
		     favUpdate.setUserid(CustomUserDetailsService.cache.get("user"));
		     favRepo.save(favUpdate);
		}
		viewBooksList(model);
	    return "booklist";
	}
	
	
}
