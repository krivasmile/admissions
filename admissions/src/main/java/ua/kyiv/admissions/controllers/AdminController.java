package ua.kyiv.admissions.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ua.kyiv.admissions.service.FacultyRegDataService;
import ua.kyiv.admissions.service.UserService;

@Controller
public class AdminController {
	private FacultyRegDataService facultyRegDataService;
	private UserService userService;

	@Autowired
	public AdminController(FacultyRegDataService facultyRegDataService, UserService userService) {
		this.facultyRegDataService = facultyRegDataService;
		this.userService = userService;
	}

	@GetMapping(value = "/admin")
	public ModelAndView showRegisteredEntrants(Principal principal) {
		ModelAndView map = new ModelAndView("admin");
		if (principal == null) {
			map.setViewName("403");
			return map;
		}
		map.addObject("registeredEntrants", facultyRegDataService.showAllEntrants());
		map.addObject("user", userService.findByEmail(principal.getName()));
		return map;
	}
}
