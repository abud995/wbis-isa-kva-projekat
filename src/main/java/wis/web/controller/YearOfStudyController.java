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

import wis.domain.YearOfStudy;
import wis.service.YearOfStudyService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/yearofstudy")
public class YearOfStudyController {

	@Autowired
	YearOfStudyService ys;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<YearOfStudy>> getYearOfStudy() {
		return new ResponseEntity<Iterable<YearOfStudy>>(ys.getYearOfStudy(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<YearOfStudy> addYearOfStudy(@RequestBody YearOfStudy YearOfStudy) {
		ys.addYearOfStudy(YearOfStudy);
		return new ResponseEntity<YearOfStudy>(YearOfStudy, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<YearOfStudy> updateYearOfStudy(@PathVariable Long id, @RequestBody YearOfStudy YearOfStudy) {
		ys.updateYearOfStudy(id, YearOfStudy);
		return new ResponseEntity<YearOfStudy>(YearOfStudy, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<YearOfStudy> getYearOfStudytById(@PathVariable Long id) {
		Optional<YearOfStudy> YearOfStudy = ys.getYearOfStudyById(id);
		if(YearOfStudy.isPresent()) {
			return new ResponseEntity<YearOfStudy>(YearOfStudy.get(), HttpStatus.OK);
		}
		return new ResponseEntity<YearOfStudy>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<YearOfStudy> removeYearOfStudy(@PathVariable Long id) {
		try {
			ys.removeYearOfStudy(id);
		}catch (Exception e) {
			return new ResponseEntity<YearOfStudy>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<YearOfStudy>(HttpStatus.NO_CONTENT);
	}
}
