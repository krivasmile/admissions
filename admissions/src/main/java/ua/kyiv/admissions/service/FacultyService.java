package ua.kyiv.admissions.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kyiv.admissions.dao.FacultyRepository;
import ua.kyiv.admissions.domain.Faculty;

@Service
public class FacultyService {
	private Logger logger =LoggerFactory.getLogger(FacultyService.class);
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	public void save(Faculty faculty) {
		facultyRepository.save(faculty);
		logger.info("Adding a new faculty " + faculty);
	}
	
	public List<Faculty> getAllFaculties(){
		logger.info("Selecting all faculties");
		return facultyRepository.findAll();
	}
	
	public void deleteAllFaculties() {
		logger.info("Deleting all faculties");
		facultyRepository.deleteAll();
	}
	
	public Faculty findById(Integer id) {
		logger.info("Selecting a faculty with id " + id);
		return facultyRepository.findById(id).get();
	}
}
