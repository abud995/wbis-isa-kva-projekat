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

import wis.domain.CourseAttending;
import wis.service.CourseAttendingService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/courseattending")
public class CourseAttendingController {

	@Autowired
	CourseAttendingService ca;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<CourseAttending>> getCourseAttending() {
		return new ResponseEntity<Iterable<CourseAttending>>(ca.getCourseAttendings(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<CourseAttending> addCourseAttending(@RequestBody CourseAttending CourseAttending) {
		ca.addCourseAttending(CourseAttending);
		return new ResponseEntity<CourseAttending>(CourseAttending, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<CourseAttending> updateCourseAttending(@PathVariable Long id, @RequestBody CourseAttending CourseAttending) {
		ca.updateCourseAttending(id, CourseAttending);
		return new ResponseEntity<CourseAttending>(CourseAttending, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<CourseAttending> getCourseAttending(@PathVariable Long id) {
		Optional<CourseAttending> CourseAttending = ca.getCourseAttendingById(id);
		if(CourseAttending.isPresent()) {
			return new ResponseEntity<CourseAttending>(CourseAttending.get(), HttpStatus.OK);
		}
		return new ResponseEntity<CourseAttending>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<CourseAttending> removeCourseAttending(@PathVariable Long id) {
		try {
			ca.removeCourseAttending(id);
		}catch (Exception e) {
			return new ResponseEntity<CourseAttending>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<CourseAttending>(HttpStatus.NO_CONTENT);
	}
}
