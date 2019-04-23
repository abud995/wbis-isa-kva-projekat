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

import wis.domain.ScientificField;
import wis.service.ScientificFieldService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/scientificfield")
public class ScientificFieldController {
	
	@Autowired
	ScientificFieldService sf;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<ScientificField>> getScientificFields() {
		return new ResponseEntity<Iterable<ScientificField>>(sf.getScientificFields(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<ScientificField> addScientificField(@RequestBody ScientificField ScientificField) {
		sf.addScientificField(ScientificField);
		return new ResponseEntity<ScientificField>(ScientificField, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<ScientificField> updateScientificFielde(@PathVariable Long id, @RequestBody ScientificField ScientificField) {
		sf.updateScientificField(id, ScientificField);
		return new ResponseEntity<ScientificField>(ScientificField, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ScientificField> getScientificFieldById(@PathVariable Long id) {
		Optional<ScientificField> ScientificField = sf.getScientificFieldById(id);
		if(ScientificField.isPresent()) {
			return new ResponseEntity<ScientificField>(ScientificField.get(), HttpStatus.OK);
		}
		return new ResponseEntity<ScientificField>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<ScientificField> removeScientificField(@PathVariable Long id) {
		try {
			sf.removeScientificField(id);
		}catch (Exception e) {
			return new ResponseEntity<ScientificField>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<ScientificField>(HttpStatus.NO_CONTENT);
	}
}
