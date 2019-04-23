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

import wis.domain.University;
import wis.service.UniversityService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/university")
public class UniversityController {

	@Autowired
	UniversityService us;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<University>> getUniversities() {
		return new ResponseEntity<Iterable<University>>(us.getUniversities(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<University> addStudent(@RequestBody University University) {
		us.addUniversity(University);
		return new ResponseEntity<University>(University, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<University> updateUniversity(@PathVariable Long id, @RequestBody University University) {
		us.updateUniversity(id, University);
		return new ResponseEntity<University>(University, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<University> getUniversityById(@PathVariable Long id) {
		Optional<University> University = us.getUniversityById(id);
		if(University.isPresent()) {
			return new ResponseEntity<University>(University.get(), HttpStatus.OK);
		}
		return new ResponseEntity<University>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<University> removeUniversity(@PathVariable Long id) {
		try {
			us.removeUniversity(id);
		}catch (Exception e) {
			return new ResponseEntity<University>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<University>(HttpStatus.NO_CONTENT);
	}
}
