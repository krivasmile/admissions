package ua.kyiv.admissions.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.kyiv.admissions.dao.UserRepository;
import ua.kyiv.admissions.domain.User;
import ua.kyiv.admissions.domain.UserRole;

@Service
public class UserService {
	private Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRole(UserRole.ROLE_USER);
		userRepository.save(user);
		logger.info("Adding a new user " + user);
	}
	
	public User findByEmail(String email) {
		logger.info("Selecting user with email " + email);
		return userRepository.findByEmail(email).get();
	}
	
	public void setImage(User user, MultipartFile image) throws IOException {
		logger.info("Setting image to user " + user);
		User userForUpdate = userRepository.findById(user.getId()).get();
		userForUpdate.setImageBase64(image);
		userRepository.save(user);
	}
}
