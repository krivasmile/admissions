package ua.kyiv.admissions.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.kyiv.admissions.dao.UserRepository;
import ua.kyiv.admissions.domain.User;
import ua.kyiv.admissions.domain.UserRole;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRole(UserRole.ROLE_USER);
		userRepository.save(user);
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email).get();
	}
	
	public void setImage(User user, MultipartFile image) throws IOException {
		User userForUpdate = userRepository.findById(user.getId()).get();
		userForUpdate.setImageBase64(image);
		userRepository.save(user);
	}
}
