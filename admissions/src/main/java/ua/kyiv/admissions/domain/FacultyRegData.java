package ua.kyiv.admissions.domain;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	
	@Transient
	private int facultyId;
	
	@Transient
	private String email;
	
	public FacultyRegData() {
		
	}

	public FacultyRegData(Faculty faculty, User user, List<Integer> marks, int facultyId, String email) {
		this.faculty = faculty;
		this.user = user;
		this.marks = marks;
	}

	public FacultyRegData(Integer id, Faculty faculty, User user, List<Integer> marks) {
		this.id = id;
		this.faculty = faculty;
		this.user = user;
		this.marks = marks;
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

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "FacultyRegData [id=" + id + ", faculty=" + faculty + ", user=" + user + ", marks=" + marks
				+ ", facultyId=" + facultyId + ", email=" + email + "]";
	}
	
	
	
}
