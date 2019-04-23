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

import wis.domain.Faculty;
import wis.service.FacultyService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/faculty")
public class FacultyController {

	@Autowired
	FacultyService fs;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<Faculty>> getFaculties() {
		return new ResponseEntity<Iterable<Faculty>>(fs.getFaculties(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Faculty> addFaculty(@RequestBody Faculty Faculty) {
		fs.addFaculty(Faculty);
		return new ResponseEntity<Faculty>(Faculty, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Faculty> updateFaculty(@PathVariable Long id, @RequestBody Faculty Faculty) {
		fs.updateFaculty(id, Faculty);
		return new ResponseEntity<Faculty>(Faculty, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Faculty> getFacultyById(@PathVariable Long id) {
		Optional<Faculty> Faculty = fs.getFacultyById(id);
		if(Faculty.isPresent()) {
			return new ResponseEntity<Faculty>(Faculty.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Faculty>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Faculty> removeFaculty(@PathVariable Long id) {
		try {
			fs.removeFaculty(id);
		}catch (Exception e) {
			return new ResponseEntity<Faculty>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Faculty>(HttpStatus.NO_CONTENT);
	}
}
