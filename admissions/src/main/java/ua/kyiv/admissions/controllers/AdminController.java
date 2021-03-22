package ua.kyiv.admissions.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ua.kyiv.admissions.service.FacultyRegDataService;

@Controller
public class AdminController {
	private FacultyRegDataService facultyRegDataService;
	
	@Autowired
	public AdminController(FacultyRegDataService facultyRegDataService) {
		this.facultyRegDataService = facultyRegDataService;
	}

	@GetMapping(value ="/admin")
	public String showRegisteredEntrants(Model model) {
		model.addAttribute("registeredEntrants", facultyRegDataService.showAllEntrants());
		return "/admin";
	}
}
