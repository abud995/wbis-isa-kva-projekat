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

import wis.domain.CourseTeaching;
import wis.service.CourseTeachingService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/courseteaching")
public class CourseTeachingController {

	@Autowired
	CourseTeachingService ct;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<CourseTeaching>> getCourses() {
		return new ResponseEntity<Iterable<CourseTeaching>>(ct.getCourseTeachings(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<CourseTeaching> addCourseTeaching(@RequestBody CourseTeaching CourseTeaching) {
		ct.addCourseTeaching(CourseTeaching);
		return new ResponseEntity<CourseTeaching>(CourseTeaching, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<CourseTeaching> updateCourseTeaching(@PathVariable Long id, @RequestBody CourseTeaching CourseTeaching) {
		ct.updateCourseTeaching(id, CourseTeaching);
		return new ResponseEntity<CourseTeaching>(CourseTeaching, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<CourseTeaching> getCourseTeachingById(@PathVariable Long id) {
		Optional<CourseTeaching> CourseTeaching = ct.getCourseTeachingById(id);
		if(CourseTeaching.isPresent()) {
			return new ResponseEntity<CourseTeaching>(CourseTeaching.get(), HttpStatus.OK);
		}
		return new ResponseEntity<CourseTeaching>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<CourseTeaching> removeCourseTeaching(@PathVariable Long id) {
		try {
			ct.removeCourseTeaching(id);
		}catch (Exception e) {
			return new ResponseEntity<CourseTeaching>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<CourseTeaching>(HttpStatus.NO_CONTENT);
	}
}
