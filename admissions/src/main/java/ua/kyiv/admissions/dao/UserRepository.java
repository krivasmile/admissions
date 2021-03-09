package ua.kyiv.admissions.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.kyiv.admissions.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
