package ua.kyiv.admissions.domain;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faculties")
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Faculties name;
	
	@ElementCollection
	private List<Subject> subjects;
	
	public Faculty() {
	}
	
	public Faculty(Faculties name, List<Subject> subjects) {
		this.name = name;
		this.subjects = subjects;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
