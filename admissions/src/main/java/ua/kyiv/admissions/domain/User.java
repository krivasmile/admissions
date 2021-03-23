package ua.kyiv.admissions.domain;

import java.io.IOException;
import java.util.Base64;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String firstName;
	private String surname;
	private String email;
	private String password;
	
	@Lob
	private String imageBase64;
	
	@Transient
	private String passwordConfirm;
	
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	public User() {
	}
	
	public User(User user) {
		this.id = user.id;
		this.firstName = user.firstName;
		this.surname = user.surname;
		this.email = user.email;
		this.password = user.password;
		this.role = user.role;
	}

	public User(String firstName, String surname, String email, String password, UserRole role) {
		this.firstName = firstName;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public User(Long id, String firstName, String surname, String email, String password, UserRole role) {
		this.id = id;
		this.firstName = firstName;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	
	public String getImageBase64() {
		return imageBase64;
	}

	public void setImageBase64(MultipartFile file) throws IOException {
		this.imageBase64 = Base64.getEncoder().encodeToString(file.getBytes());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", surname=" + surname + ", email=" + email
				+ ", password=" + password + ", role=" + role + "]";
	}
}
