package ua.kyiv.admissions.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.kyiv.admissions.domain.FacultyRegData;
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

	@ModelAttribute
	public void addAttribute(Model model, @RequestParam("facultyId") Integer id, @RequestParam("email") String email) {
		FacultyRegData frd = new FacultyRegData();
		frd.setFaculty(facultyService.findById(id));
		frd.setUser(userService.findByEmail(email));
		model.addAttribute("facultyRegData", frd);
	}

	@GetMapping(value = "/registrationEntrant")
	public ModelAndView registrationEntrant(@RequestParam("email") String email) {
		ModelAndView map = new ModelAndView("registrationEntrant");
		map.addObject("user", userService.findByEmail(email));
		return map;
	}

	@PostMapping("/registrationEntrant")
	public String addRegistration(@RequestParam List<Integer> marksFromForm,
			@ModelAttribute("facultyRegData") FacultyRegData frd) {
		frd.setMarksFromList(marksFromForm);
		frd.setAdmissionForEntrant();
		facultyRegDataService.save(frd);
		return "redirect:/home";
	}

}
