package ua.kyiv.admissions.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private Map<Subject, Integer> marks = new HashMap<Subject, Integer>();
	
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
	
	public boolean getIsEnrolled() {
		return isEnrolled;
	}

	public void setEnrolled(boolean isEnrolled) {
		this.isEnrolled = isEnrolled;
	}
	
	public Map<Subject, Integer> getMarks() {
		return marks;
	}
	
	public void setMarks(Map<Subject, Integer> marks) {
		this.marks = marks;
	}
	
	public void setMarksFromList(List <Integer> listOfMarks) {
		for (int i = 0; i < faculty.getSubjects().size(); i++) {
			marks.put(faculty.getSubjects().get(i), listOfMarks.get(i));
		}
	}

	public void setAdmissionForEntrant() {
		int summOfMarks = marks.values().stream().reduce(0, Integer::sum);
		isEnrolled = summOfMarks / faculty.getSubjects().size() >= 10 ? true : false;
	}
}
