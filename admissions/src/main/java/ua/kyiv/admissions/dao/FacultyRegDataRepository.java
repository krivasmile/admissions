package ua.kyiv.admissions.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.kyiv.admissions.domain.FacultyRegData;

@Repository
public interface FacultyRegDataRepository extends JpaRepository<FacultyRegData, Integer> {

}
