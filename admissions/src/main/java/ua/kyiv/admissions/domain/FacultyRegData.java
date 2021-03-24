package ua.kyiv.admissions.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="faculty_reg_form")
public class FacultyRegData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne()
	@JoinColumn(name ="faculty_id", referencedColumnName = "id")
	private Faculty faculty;
	
	@ManyToOne()
	@JoinColumn(name ="user_id", referencedColumnName = "id")
	private User user;
	
	@ElementCollection
	private List<Integer> marks;
	
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean isEnrolled;
	
	public FacultyRegData() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Integer> getMarks() {
		return marks;
	}

	public void setMarks(List<Integer> marks) {
		this.marks = marks;
	}
	
	public boolean getIsEnrolled() {
		return isEnrolled;
	}

	public void setEnrolled(boolean isEnrolled) {
		this.isEnrolled = isEnrolled;
	}
	
	public void setAdmissionOfEntrant() {
		int summOfMarks = marks.stream().mapToInt(Integer::intValue).sum();
		isEnrolled = summOfMarks / faculty.getSubjects().size() >= 10 ? true : false;
	}
}
