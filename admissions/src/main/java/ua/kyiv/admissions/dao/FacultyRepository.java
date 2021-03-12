package ua.kyiv.admissions.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.kyiv.admissions.domain.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

}
