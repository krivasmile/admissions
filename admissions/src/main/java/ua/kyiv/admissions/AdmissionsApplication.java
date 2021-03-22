package ua.kyiv.admissions;

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
	
	public static void main(String[] args) {
		SpringApplication.run(AdmissionsApplication.class, args);
//		ConfigurableApplicationContext ctx = SpringApplication.run(AdmissionsApplication.class, args);
//		
//		FacultyRegDataService facultyRegDataService = ctx.getBean(FacultyRegDataService.class);
//		FacultyService facultyService = ctx.getBean(FacultyService.class);
//		
//		facultyRegDataService.deleteAllEntrants();
//		facultyService.deleteAllFaculties();
//		List<Subject> subjects = new ArrayList<>();
//		for (int i = 0; i < Subject.values().length; i++) {
//			subjects.add(Subject.values()[i]);
//		}
//		facultyService.save(new Faculty(Faculties.JAVA, subjects));
//		facultyService.save(new Faculty(Faculties.PYTHON, subjects));
//		facultyService.save(new Faculty(Faculties.ANDROID, subjects));
	}

}
