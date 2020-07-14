package org.sid;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Blob;
import java.util.Date;
import java.util.zip.Deflater;

import javax.imageio.ImageIO;

import org.hibernate.engine.jdbc.BlobProxy;
import org.sid.dao.AgentDao;
import org.sid.dao.CourseDao;
import org.sid.dao.InstitutDao;
import org.sid.dao.ManagerDao;
import org.sid.dao.PlaceDao;
import org.sid.dao.SessionDao;
import org.sid.dao.StudentDao;
import org.sid.dao.TeacherDao;
import org.sid.entites.Agent;
import org.sid.entites.Course;
import org.sid.entites.Institut;
import org.sid.entites.Manager;
import org.sid.entites.Place;
import org.sid.entites.Session;
import org.sid.entites.Student;
import org.sid.entites.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
      
public class ELearningApplication implements CommandLineRunner {

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private PlaceDao placeDao;
	
	@Autowired
	private ManagerDao managerDao;
	
	@Autowired
	private TeacherDao teacherDao;
	
	@Autowired
	private AgentDao agentDao;
	
	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private SessionDao sessionDao;
	
	@Autowired
	private InstitutDao institutDao;
	 
    @Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    
	 @Bean
	    BCryptPasswordEncoder getBCPE(){
	        return new BCryptPasswordEncoder();
	    }


	public static void main(String[] args) {
		SpringApplication.run(ELearningApplication.class, args);
	}
	
 
	
	  @Override 
	  public void run(String... args) throws Exception {
		    
		repositoryRestConfiguration.exposeIdsFor
		(Session.class,Course.class,Student.class,Institut.class,Agent.class,Manager.class,Place.class);
		
		// Institut institut1=institutDao.findById((long) 1).get();

		//System.out.println(bCryptPasswordEncoder.encode("1234567")); 
		
		Student student=studentDao.findByName("karim");
		System.out.println(bCryptPasswordEncoder.matches("123456", student.getPassword()));
		 
	  }
}


