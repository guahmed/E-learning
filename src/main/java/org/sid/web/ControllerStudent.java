package org.sid.web;

import java.util.List;

import javax.management.RuntimeErrorException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.SQLException;

import org.hibernate.engine.jdbc.BlobProxy;
import org.sid.dao.CourseDao;
import org.sid.dao.InstitutDao;
import org.sid.dao.SessionDao;
import org.sid.dao.StudentDao;
import org.sid.entites.Agent;
import org.sid.entites.Course;
import org.sid.entites.Institut;
import org.sid.entites.Place;
import org.sid.entites.Session;
import org.sid.entites.Student;
import org.sid.exception.ChangePasswordException;
import org.sid.service.ChangePassword;
import org.sid.service.ObjectServiceChangePassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;



@RestController
@CrossOrigin("*")
@RequestMapping("/student" )
public class ControllerStudent {
	
	@Autowired
	private ControllerStudent controller;
	
	@Autowired
	private StudentDao studentDao;

	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private InstitutDao institutDao;
	
	@Autowired
	private SessionDao sessionDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private ChangePassword changePassword;

	@PostMapping(path = "/subscribe/secondstep")
	public String testsub(Model model, Student std) {

		studentDao.save(std);

		return "redirect:/index";
	}
	

	@GetMapping(path = "/template")
	public String temp() {

		return "template";
	}
	

	
	@GetMapping(path="/photoFormation/{id}")
	public ResponseEntity<byte[]> getPhoto(@PathVariable("id")Long id) throws SQLException {
		Session session=sessionDao.findById(id).get();
		//Files.readAllBytes( form.getPhoto());
	
		return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(session.getImage().getBytes(1, (int) session.getImage().length()));
	}
	
	//@GetMapping(path="/anvailible")
	
	@GetMapping(path="/getStudentinfo/{id}")
	public Student getStudent(@PathVariable("id") Long id) {
		
		return studentDao.findById(id).get();
	}
	
	
	
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable("id") Long id) {
		studentDao.deleteById(id);
	}
	
	@PostMapping("/uploadPhoto/{name}")
	public void uploadPhoto(@PathVariable("name") String name,
			@RequestParam("file") MultipartFile file ) throws IOException {
		
		Student student =studentDao.findByName(name);
		System.out.println(file.getBytes());
		student.setPhoto(BlobProxy.generateProxy(file.getBytes()));  
		
		studentDao.save(student);
		
		//return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(student.getPhoto());

		
	}
	
	
	@GetMapping("/getStudent/{name}")
	public Student addStudent(@PathVariable("name") String name ) {
		return	studentDao.findByName(name);
	}
	
	@GetMapping("/getPhotoUser/{name}")
	public ResponseEntity<byte[]> getPhotoUser(@PathVariable("name") String name) throws SQLException{
		Student student =studentDao.findByName(name);
		
		return ResponseEntity.ok().
				contentType(MediaType.IMAGE_PNG).
					body(student.getPhoto().getBytes(1, (int) student.getPhoto().length()));
	}
	
	
	
	@PutMapping("updateStudent/{name}")
	public Student updateStudent(@PathVariable("name") String name,
			@RequestBody Student studentAfter) {
			
		Student studentBefore=studentDao.findByName(name);
		System.out.println("email"+studentBefore.getEmail());
		
		studentBefore.setName(studentAfter.getName());
		studentBefore.setLastName(studentAfter.getLastName());
		studentBefore.setAge(studentAfter.getAge());
		studentBefore.setIdCard(studentAfter.getIdCard());
		//studentBefore.setPassword(bCryptPasswordEncoder.encode(studentAfter.getPassword()));
		studentBefore.setEmail(studentAfter.getEmail());
		studentBefore.setRole(studentAfter.getRole());
		studentBefore.setAdress(studentAfter.getAdress()); 
		studentBefore.setExperience(studentAfter.getExperience());
		
		
		//studentBefore.setId(id);
		return studentDao.save(studentBefore);
		/*
		 * std.setAge(age); std.setEmail(email); std.setIdCard(idCard);
		 * std.setLastName(lastName); std.setName(name); std.setPhoto(photo);
		 */
	}
	
	
	
	
	
	@PostMapping("/SubscribeSession")
	
	public void Subscribe(@RequestBody StudentAndSession objet ) {
		
		
		  Student student=studentDao.findByName(objet.StudentName);
		
		/*
		 * Session session =sessionDao.findByName(objet.SessionName);
		 * 
		 * if (session.getInscribedStudent().contains(student)) throw new
		 * RuntimeException("Vous etes deja inscri"); else {
		 * 
		 * session.getInscribedStudent().add(student);
		 * 
		 * }
		 * 
		 * //session.getInscribedStudent().clean();
		 * session.getInscribedStudent().forEach(s->System.out.print(s.getAdresse()));
		 */
		
	}

	@GetMapping("/testinstitutPlace")
	public ResponseEntity<Course> diplayPlace(){
		
		Course course = courseDao.findById((long) 1).get();
		
		return new ResponseEntity<Course>(course
				,HttpStatus.OK);
		
	}
	
	@GetMapping("/aaa")
	public String getuser(){
		
		Object principal = SecurityContextHolder.getContext().
				getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			 String username = ((UserDetails)principal).getUsername();
			 return username;
		} else {
			String username = principal.toString();
			return username;
		}	
	
	}
	
	
	
	
	@GetMapping("/changePassword"  )
	public void changePassword( 
			@RequestBody ObjectServiceChangePassword objectServiceChangePassword  )
	{
		System.out.print(objectServiceChangePassword.toString());
		
		changePassword.CheckAndSavePassword(objectServiceChangePassword.getName()
				, objectServiceChangePassword.getOldPassword()
				, objectServiceChangePassword.getNewPassword()
				, objectServiceChangePassword.getConfirmPassWord());
	}
	
	
}
