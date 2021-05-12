package ua.kyiv.admissions;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import ua.kyiv.admissions.dao.FacultyRegDataRepository;
import ua.kyiv.admissions.dao.FacultyRepository;
import ua.kyiv.admissions.dao.UserRepository;
import ua.kyiv.admissions.domain.Faculties;
import ua.kyiv.admissions.domain.Faculty;
import ua.kyiv.admissions.domain.FacultyRegData;
import ua.kyiv.admissions.domain.Subject;
import ua.kyiv.admissions.domain.User;
import ua.kyiv.admissions.domain.UserRole;
import ua.kyiv.admissions.service.FacultyRegDataService;
import ua.kyiv.admissions.service.FacultyService;
import ua.kyiv.admissions.service.UserService;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class AdmissionsApplicationTests {
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FacultyService facultyService;

	@Autowired
	private FacultyRepository facultyRepository;

	@Autowired
	private FacultyRegDataService facultyRegDataService;

	@Autowired
	private FacultyRegDataRepository facultyRegDataRepository;

	private static User user;
	private static User user2;
	private static Faculty faculty;
	private static Faculty faculty2;

	@Before
	public void setUp() {
		user = new User();
		user.setEmail("test@test.com");
		user.setFirstName("test");
		user.setSurname("testSurname");
		user.setPassword("noPassword");

		user2 = new User();
		user2.setEmail("user2@test.com");
		user2.setFirstName("user2");
		user2.setSurname("user2Surname");
		user2.setPassword("noPassword2");
		user2.setRole(UserRole.ROLE_ADMIN);
		
		faculty = new Faculty();
		faculty.setName(Faculties.JAVA);
		faculty.setDescription("test");
		faculty.setSubjects(new ArrayList<Subject>(Arrays.asList(Subject.MATHEMATICS, Subject.COMPUTER_SCIENCE)));
		
		faculty2 = new Faculty();
		faculty2.setName(Faculties.PYTHON);
		faculty2.setDescription("test Python");
		faculty2.setSubjects(new ArrayList<Subject>(Arrays.asList(Subject.MATHEMATICS, Subject.COMPUTER_SCIENCE)));
		
		try {
			faculty.setImageBase64(new File("src\\main\\resources\\static\\image\\java.png"));
			faculty2.setImageBase64(new File("src\\main\\resources\\static\\image\\python.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testSaveUser() {
		userService.save(user);

		List<User> users = userRepository.findAll();
		assertTrue(users.size() == 1);

		User userFromDB = users.get(0);
		assertEquals(userFromDB, user);
	}

	@Test
	public void testFindByEmail() {
		userRepository.saveAll(Arrays.asList(user, user2));

		List<User> users = userRepository.findAll();
		assertTrue(users.size() == 2);

		User userFindedByEmail = userService.findByEmail(user2.getEmail());

		assertEquals(userFindedByEmail, user2);
	}

	@Test
	public void testSetImage() throws IOException {
		userService.save(user);

		User userFromDB = userRepository.findAll().get(0);

		assertNull(userFromDB.getImageBase64());
		
		//getting multipartFile from local disk
		Path path = Paths.get("src\\main\\resources\\static\\image\\java.png");
		String name = "java.png";
		String originalFileName = "java.png";
		String contentType = "text/plain";
		byte[] content = Files.readAllBytes(path);
		MultipartFile image = new MockMultipartFile(name, originalFileName, contentType, content);

		userService.setImage(userFromDB, image);

		assertNotNull(userFromDB.getImageBase64());
	}

	@Test
	public void testSaveFaculty() throws IOException {
		facultyService.save(faculty);

		List<Faculty> faculties = facultyRepository.findAll();
		assertTrue(faculties.size() == 1);

		Faculty facultyFromDB = faculties.get(0);
		assertEquals(facultyFromDB, faculty);
	}

	@Test
	public void testGetAllFaculties() throws IOException {
		facultyRepository.saveAll(Arrays.asList(faculty, faculty2));

		List<Faculty> expected = facultyRepository.findAll();
		
		List<Faculty> actual = new ArrayList<>();
		actual.add(faculty);
		actual.add(faculty2);
		
		assertEquals(expected, actual);
	}

	@Test
	public void testFindById() throws IOException {
		facultyRepository.saveAll(Arrays.asList(faculty, faculty2));

		List<Faculty> faculties = facultyRepository.findAll();
		assertTrue(faculties.size() == 2);

		Faculty facultyFromDB = facultyService.findById(faculties.get(1).getId());

		assertEquals(facultyFromDB, faculty2);

	}

	@Test
	public void testSaveRegData() {
		userService.save(user);
		User userFromDB = userRepository.findAll().get(0);
		
		facultyService.save(faculty);
		Faculty facultyFromDB = facultyRepository.findAll().get(0);
		
		FacultyRegData facultyRegData = new FacultyRegData();
		facultyRegData.setFaculty(facultyFromDB);
		facultyRegData.setUser(userFromDB);
		facultyRegData.setMarksFromList(new ArrayList<Integer>(Arrays.asList(10,10)));
		facultyRegData.setEnrolled(true);
		
		facultyRegDataService.save(facultyRegData);
		
		List<FacultyRegData> facultyRegDataList = facultyRegDataRepository.findAll();
		assertTrue(facultyRegDataList.size() == 1);
		
		FacultyRegData facultyRegDataFromDB = facultyRegDataList.get(0);
		
		assertEquals(facultyRegDataFromDB, facultyRegData);
	}
	
	@Test
	public void testShowAllEntrants() {
		userService.save(user);
		userService.save(user2);
		User userFromDB = userRepository.findAll().get(0);
		User userFromDB2 = userRepository.findAll().get(1);
		
		facultyService.save(faculty);
		facultyService.save(faculty2);
		Faculty facultyFromDB = facultyRepository.findAll().get(0);
		Faculty facultyFromDB2 = facultyRepository.findAll().get(1);
		
		FacultyRegData facultyRegData = new FacultyRegData();
		facultyRegData.setFaculty(facultyFromDB);
		facultyRegData.setUser(userFromDB);
		facultyRegData.setMarksFromList(new ArrayList<Integer>(Arrays.asList(10,10)));
		facultyRegData.setEnrolled(true);
		
		FacultyRegData facultyRegData2 = new FacultyRegData();
		facultyRegData2.setFaculty(facultyFromDB2);
		facultyRegData2.setUser(userFromDB2);
		facultyRegData2.setMarksFromList(new ArrayList<Integer>(Arrays.asList(10,10)));
		facultyRegData2.setEnrolled(true);
		
		facultyRegDataRepository.saveAll(Arrays.asList(facultyRegData, facultyRegData2));
		
		List<FacultyRegData> actual = new ArrayList<>();
		actual.add(facultyRegData2);
		actual.add(facultyRegData);
		
		List<FacultyRegData> expected = facultyRegDataService.showAllEntrants();
		assertTrue(expected.size() == 2);
		
		assertEquals(expected, actual);
	}

}
