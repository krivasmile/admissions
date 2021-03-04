package ua.kyiv.admissions.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.kyiv.admissions.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
