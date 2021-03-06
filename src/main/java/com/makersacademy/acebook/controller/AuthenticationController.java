package com.makersacademy.acebook.controller;


import com.makersacademy.acebook.model.*;
import com.makersacademy.acebook.model.Post;
import com.makersacademy.acebook.repository.CommentRepository;
import com.makersacademy.acebook.repository.PostRepository;
import com.makersacademy.acebook.repository.UserRepository;
import com.makersacademy.acebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AuthenticationController {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Autowired
	public AuthenticationController(PostRepository postRepository, CommentRepository commentRepository) {
		this.postRepository = postRepository;
        this.commentRepository = commentRepository;
	}

    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
	public String index() {
		return "login";
	}

    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login"); // resources/template/login.html
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register"); // resources/template/register.html
        return modelAndView;
    }

    @RequestMapping(value="/register", method=RequestMethod.POST)
    public ModelAndView registerUser(@Valid User user) {
        ModelAndView modelAndView = new ModelAndView();
        // Check for the validations
        if(userService.isUserAlreadyPresent(user)){
            modelAndView.addObject("successMessage", "user already exists!");
        }
        // we will save the user if, no binding errors
        else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User is registered successfully!");
        }
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home"); // resources/template/home.html
        return modelAndView;
    }

    @GetMapping(value = "/post")
	public String post(Model model) {
		model.addAttribute("post", new PostForm("Write post here.."));
		return "post";
	}

	@PostMapping(value = "/post")
	public RedirectView post(@ModelAttribute Post post) {
		postRepository.save(post);
		return new RedirectView("/home");
	}

    @GetMapping(value = "/post/{post_id}/comment")
    public ModelAndView comment(Model model, HttpServletRequest request, @PathVariable Long post_id) {
        HttpSession session = request.getSession();
        model.addAttribute("comment", new CommentForm("Content", post_id));
        return new ModelAndView("comment");
    }

    @PostMapping(value = "/comment")
    public RedirectView comment(@ModelAttribute Comment comment) {
        commentRepository.save(comment);
        return new RedirectView("/home");
    }
}
