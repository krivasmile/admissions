package ua.kyiv.admissions.controllers;

import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ua.kyiv.admissions.domain.User;
import ua.kyiv.admissions.service.FacultyService;
import ua.kyiv.admissions.service.UserService;

@Controller
public class UserController {
	
	private UserService userService;
	private FacultyService facultyService;
	
	@Autowired
	public UserController(UserService userService, FacultyService facultyService) {
		this.userService = userService;
		this.facultyService = facultyService;
	}

	@GetMapping(value = { "/", "/login" })
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");
		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");
		return "login";
	}
	
	@GetMapping(value = "/registration")
	public String registration(Model model) {
		model.addAttribute("newUser", new User());
		return "registration";
	}
	
	@PostMapping(value = "/registration")
	public String register(@ModelAttribute("newUser") User user, BindingResult bindingResult) throws IOException {
		if (bindingResult.hasErrors())
			return "/registration";
		userService.save(user);
		return "redirect:/login";
	}

	@GetMapping(value = "/home")
	public ModelAndView welcome(Principal principal) {
			ModelAndView map = new ModelAndView("home");
			map.addObject("faculties", facultyService.getAllFaculties());
			map.addObject("user", userService.findByEmail(principal.getName()));
		return map;
	}
	
	@PostMapping(value="/imageUpload")
	public String imageUpload(@RequestParam MultipartFile image, Principal principal) throws IOException {
		userService.setImage(userService.findByEmail(principal.getName()), image);
		return "redirect:/home";
	}
}
