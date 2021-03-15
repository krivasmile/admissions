package ua.kyiv.admissions.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ua.kyiv.admissions.domain.User;
import ua.kyiv.admissions.service.FacultyService;
import ua.kyiv.admissions.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FacultyService facultyService;
	
	@GetMapping(value = { "/", "/login" })
	public String login(Model model, String error, String logout) {
		model.addAttribute("userForm", new User());
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");
		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");
		return "login";
	}

	@PostMapping(value = { "/", "/login" })
	public String registration(@ModelAttribute("userForm") User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "/login";
		userService.save(user);
		return "redirect:/home";
	}

	@GetMapping(value = "/home")
	public ModelAndView welcome() {
			ModelAndView map = new ModelAndView("home");
			map.addObject("faculties", facultyService.getAllFaculties());
		return map;
	}
}
