package ua.kyiv.admissions.service;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kyiv.admissions.dao.FacultyRegDataRepository;
import ua.kyiv.admissions.domain.FacultyRegData;

@Service
public class FacultyRegDataService {
	private Logger logger =LoggerFactory.getLogger(FacultyRegDataService.class);
	
	@Autowired
	private FacultyRegDataRepository facultyRegDataRepository;
	
	public void save(FacultyRegData facultyRegData) {
		facultyRegDataRepository.save(facultyRegData);
		logger.info("Adding a new faculty registration " + facultyRegData);
	}
	
	public List<FacultyRegData> showAllEntrants(){
		logger.info("Get all faculty registrations");
		List<FacultyRegData> allEntrants = facultyRegDataRepository.findAll();
		Collections.sort(allEntrants, (f1, f2) -> f2.getFaculty().getName().compareTo(f1.getFaculty().getName()));
		return allEntrants;
	}
	
	public void deleteAllEntrants() {
		logger.info("Delete all faculty registrations");
		facultyRegDataRepository.deleteAll();
	}
}
