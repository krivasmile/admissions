package ua.kyiv.admissions.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.kyiv.admissions.domain.Faculty;
import ua.kyiv.admissions.domain.FacultyRegData;
import ua.kyiv.admissions.domain.User;
import ua.kyiv.admissions.service.FacultyRegDataService;
import ua.kyiv.admissions.service.FacultyService;
import ua.kyiv.admissions.service.UserService;

@Controller
public class EntrantController {

	private FacultyService facultyService;
	private UserService userService;
	private FacultyRegDataService facultyRegDataService;
	
	@Autowired
	public EntrantController(FacultyService facultyService, UserService userService,
			FacultyRegDataService facultyRegDataService) {
		this.facultyService = facultyService;
		this.userService = userService;
		this.facultyRegDataService = facultyRegDataService;
	}

	@GetMapping(value="/registrationEntrant")
	public ModelAndView registrationEntrant(@RequestParam("facultyId") Integer id, @RequestParam("email") String email) {
		FacultyRegData frd = new FacultyRegData();
		frd.setFaculty(facultyService.findById(id));
		frd.setUser(userService.findByEmail(email));
		ModelAndView map = new ModelAndView("registrationEntrant");
		map.addObject("facultyRegData", frd);
		return map;
	}

	@PostMapping("/registrationEntrant")
	public String addRegistration(@ModelAttribute("facultyRegData") FacultyRegData frd) {
		Faculty faculty = facultyService.findById(frd.getFacultyId());
		User user = userService.findByEmail(frd.getEmail());
		frd.setFaculty(faculty);
		frd.setUser(user);
		facultyRegDataService.save(frd);
		return "redirect:/home";
	}
	
	@GetMapping(value ="/admin")
	public String showRegisteredEntrants(Model model) {
		model.addAttribute("registeredEntrants", facultyRegDataService.showAllEntrants());
		return "/admin";
	}
}
