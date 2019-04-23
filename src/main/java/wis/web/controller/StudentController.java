package wis.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import wis.domain.Student;
import wis.service.StudentService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService ss;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<Student>> getStudents() {
		return new ResponseEntity<Iterable<Student>>(ss.getStudents(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Student> addStudent(@RequestBody Student Student) {
		ss.addStudent(Student);
		return new ResponseEntity<Student>(Student, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student Student) {
		ss.updateStudent(id, Student);
		return new ResponseEntity<Student>(Student, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		Optional<Student> Student = ss.getStudentById(id);
		if(Student.isPresent()) {
			return new ResponseEntity<Student>(Student.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Student> removeStudent(@PathVariable Long id) {
		try {
			ss.removeStudent(id);
		}catch (Exception e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
	}
}
