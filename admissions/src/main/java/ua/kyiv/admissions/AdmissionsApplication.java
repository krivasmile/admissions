package ua.kyiv.admissions;


import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import ua.kyiv.admissions.domain.Faculties;
import ua.kyiv.admissions.domain.Faculty;
import ua.kyiv.admissions.domain.Subject;
import ua.kyiv.admissions.service.FacultyRegDataService;
import ua.kyiv.admissions.service.FacultyService;

@SpringBootApplication
@ComponentScan({"ua.kyiv.admissions"})
public class AdmissionsApplication {
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		SpringApplication.run(AdmissionsApplication.class, args);
//		ConfigurableApplicationContext ctx = SpringApplication.run(AdmissionsApplication.class, args);
//		
//		FacultyRegDataService facultyRegDataService = ctx.getBean(FacultyRegDataService.class);
//		FacultyService facultyService = ctx.getBean(FacultyService.class);
//		
//		facultyRegDataService.deleteAllEntrants();
//		facultyService.deleteAllFaculties();
//		
//		List<Subject> subjects = new ArrayList<>();
//		for (int i = 0; i < Subject.values().length; i++) {
//			subjects.add(Subject.values()[i]);
//		}
//		
//		Faculty java = new Faculty();
//		java.setName(Faculties.JAVA);
//		java.setSubjects(subjects);
//		java.setDescription("Java is the best");
//		java.setImageBase64(new File("src\\main\\resources\\static\\image\\java.png"));
//		
//		Faculty python = new Faculty();
//		python.setName(Faculties.PYTHON);
//		python.setSubjects(subjects);
//		python.setDescription("Python is the best");
//		python.setImageBase64(new File("src\\main\\resources\\static\\image\\python.png"));
//		
//		Faculty android = new Faculty();
//		android.setName(Faculties.ANDROID);
//		android.setSubjects(subjects);
//		android.setDescription("Android is the best");
//		android.setImageBase64(new File("src\\main\\resources\\static\\image\\android.png"));
//		
//		Faculty go = new Faculty();
//		go.setName(Faculties.GO);
//		go.setSubjects(subjects);
//		go.setDescription("Ruby is the best");
//		go.setImageBase64(new File("src\\main\\resources\\static\\image\\go.png"));
//		
//		facultyService.save(java);
//		facultyService.save(python);
//		facultyService.save(android);
//		facultyService.save(go);

	}

}
