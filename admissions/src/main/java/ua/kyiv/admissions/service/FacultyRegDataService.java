package ua.kyiv.admissions.service;

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
	
	public List<FacultyRegData> showAllRegisteredUsers(){
		return facultyRegDataRepository.findAll();
	}
	
	public void deleteAllRegisteredUsers() {
		facultyRegDataRepository.deleteAll();
	}
}
