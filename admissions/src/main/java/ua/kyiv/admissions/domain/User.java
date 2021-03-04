package ua.kyiv.admissions.domain;

import java.util.Map;

public class User {
	private Long id;
	private String firstName;
	private String surName;
	private String email;
	private String password;
	private UserRole role;
	private Faculty facultyName;
	private Map<Subject, Integer> subjectsPoints;
	
	public User() {
	}

	public User(String firstName, String surName, String email, String password) {
		this.firstName = firstName;
		this.surName = surName;
		this.email = email;
		this.password = password;
		this.role = UserRole.ADMIN;
	}

	public User(String firstName, String surName, String email, String password, Faculty facultyName, Map<Subject, Integer> subjectsPoints) {
		this.firstName = firstName;
		this.surName = surName;
		this.email = email;
		this.password = password;
		this.facultyName = facultyName;
		this.subjectsPoints = subjectsPoints;
		this.role = UserRole.USER;
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

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
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

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public Faculty getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(Faculty facultyName) {
		this.facultyName = facultyName;
	}

	public Map<Subject, Integer> getSubjectsPoints() {
		return subjectsPoints;
	}

	public void setSubjectsPoints(Map<Subject, Integer> subjectsPoints) {
		this.subjectsPoints = subjectsPoints;
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
		return "User [id=" + id + ", firstName=" + firstName + ", surName=" + surName + ", email=" + email
				+ ", password=" + password + ", role=" + role + ", facultyName=" + facultyName + ", subjectsPoints="
				+ subjectsPoints + "]";
	}
}
