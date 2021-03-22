package ua.kyiv.admissions.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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

	@ModelAttribute
	public void addAttribute(Model model, @RequestParam("facultyId") Integer id, @RequestParam("email") String email) {
		FacultyRegData frd = new FacultyRegData();
		frd.setFaculty(facultyService.findById(id));
		frd.setUser(userService.findByEmail(email));
		model.addAttribute("facultyRegData", frd);
	}

	@GetMapping(value = "/registrationEntrant")
	public String registrationEntrant() {
		return "registrationEntrant";
	}

	@PostMapping("/registrationEntrant")
	public String addRegistration(@RequestParam MultipartFile image, @RequestParam List<Integer> marks,
			@ModelAttribute("facultyRegData") FacultyRegData frd) throws IOException {
		frd.setBase64(image);
		frd.setMarks(marks);
		facultyRegDataService.save(frd);
		return "redirect:/home";
	}
}
