package ua.kyiv.admissions.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.kyiv.admissions.domain.Faculties;
import ua.kyiv.admissions.domain.Faculty;
import ua.kyiv.admissions.domain.FacultyRegData;
import ua.kyiv.admissions.domain.Subject;
import ua.kyiv.admissions.domain.User;
import ua.kyiv.admissions.domain.UserRole;
import ua.kyiv.admissions.service.FacultyRegDataService;
import ua.kyiv.admissions.service.FacultyService;
import ua.kyiv.admissions.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FacultyService facultyService;
	
	@Autowired
	private FacultyRegDataService facultyRegDataService;
	
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
//			facultyRegDataService.deleteAllRegisteredUsers();
//			facultyService.deleteAllFaculties();
//			List<Subject> subjects = new ArrayList<>();
//			for (int i = 0; i < Subject.values().length; i++) {
//				subjects.add(Subject.values()[i]);
//			}
//			facultyService.save(new Faculty(Faculties.JAVA, subjects));
//			facultyService.save(new Faculty(Faculties.PYTHON, subjects));
//			facultyService.save(new Faculty(Faculties.ANDROID, subjects));
			
			ModelAndView map = new ModelAndView("home");
			map.addObject("faculties", facultyService.getAllFaculties());
		return map;
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
}
