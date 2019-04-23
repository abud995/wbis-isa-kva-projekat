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

import wis.domain.CourseRealization;
import wis.service.CourseRealizationService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/courserealization")
public class CourseRealizationController {
	
	@Autowired
	CourseRealizationService cr;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<CourseRealization>> getCourseRealizations() {
		return new ResponseEntity<Iterable<CourseRealization>>(cr.getCourseRealizations(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<CourseRealization> addCourseRealization(@RequestBody CourseRealization CourseRealization) {
		cr.addCourseRealization(CourseRealization);
		return new ResponseEntity<CourseRealization>(CourseRealization, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<CourseRealization> updateCourseRealization(@PathVariable Long id, @RequestBody CourseRealization CourseRealization) {
		cr.updateCourseRealization(id, CourseRealization);
		return new ResponseEntity<CourseRealization>(CourseRealization, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<CourseRealization> getCourseRealization(@PathVariable Long id) {
		Optional<CourseRealization> CourseRealization = cr.getCourseRealizationById(id);
		if(CourseRealization.isPresent()) {
			return new ResponseEntity<CourseRealization>(CourseRealization.get(), HttpStatus.OK);
		}
		return new ResponseEntity<CourseRealization>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<CourseRealization> removeCourseAttending(@PathVariable Long id) {
		try {
			cr.removeCourseRealization(id);
		}catch (Exception e) {
			return new ResponseEntity<CourseRealization>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<CourseRealization>(HttpStatus.NO_CONTENT);
	}
}
