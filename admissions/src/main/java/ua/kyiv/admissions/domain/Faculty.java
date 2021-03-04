package ua.kyiv.admissions.domain;

import java.util.List;

public class Faculty {
	private Long id;
	private Faculties name;
	private List<Subject> subjects;
	
	public Faculty() {
	}
	
	public Faculty(Faculties name, List<Subject> subjects) {
		this.name = name;
		this.subjects = subjects;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Faculties getName() {
		return name;
	}

	public void setName(Faculties name) {
		this.name = name;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", subjects=" + subjects + "]";
	}

}
