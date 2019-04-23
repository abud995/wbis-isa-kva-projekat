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

import wis.domain.Course;
import wis.service.CourseService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	CourseService cs;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<Course>> getCourses() {
		return new ResponseEntity<Iterable<Course>>(cs.getCourses(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Course> addCourse(@RequestBody Course Course) {
		cs.addCourse(Course);
		return new ResponseEntity<Course>(Course, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course Course) {
		cs.updateCourse(id, Course);
		return new ResponseEntity<Course>(Course, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
		Optional<Course> Course = cs.getCourseById(id);
		if(Course.isPresent()) {
			return new ResponseEntity<Course>(Course.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Course> removeCourse(@PathVariable Long id) {
		try {
			cs.removeCourse(id);
		}catch (Exception e) {
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Course>(HttpStatus.NO_CONTENT);
	}
}
