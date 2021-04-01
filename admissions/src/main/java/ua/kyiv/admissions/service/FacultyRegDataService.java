package ua.kyiv.admissions.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kyiv.admissions.dao.FacultyRegDataRepository;
import ua.kyiv.admissions.domain.FacultyRegData;

@Service
public class FacultyRegDataService {
	
	@Autowired
	private FacultyRegDataRepository facultyRegDataRepository;
	
	public void save(FacultyRegData facultyRegData) {
		facultyRegDataRepository.save(facultyRegData);
	}
	
	public List<FacultyRegData> showAllEntrants(){
		List<FacultyRegData> allEntrants = facultyRegDataRepository.findAll();
		Collections.sort(allEntrants, (f1, f2) -> f2.getFaculty().getName().compareTo(f1.getFaculty().getName()));
		return allEntrants;
	}
	
	public void deleteAllEntrants() {
		facultyRegDataRepository.deleteAll();
	}
}
