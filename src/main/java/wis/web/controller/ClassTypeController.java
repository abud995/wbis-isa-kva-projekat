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

import wis.domain.ClassType;
import wis.service.ClassTypeService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/classtype")
public class ClassTypeController {

	@Autowired
	ClassTypeService ct;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<ClassType>> getClassType() {
		return new ResponseEntity<Iterable<ClassType>>(ct.getClassTypes(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<ClassType> addAClassType(@RequestBody ClassType ClassType) {
		ct.addClassType(ClassType);
		return new ResponseEntity<ClassType>(ClassType, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<ClassType> updateClassType(@PathVariable Long id, @RequestBody ClassType ClassType) {
		ct.updateClassType(id, ClassType);
		return new ResponseEntity<ClassType>(ClassType, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ClassType> getClassTypeById(@PathVariable Long id) {
		Optional<ClassType> ClassType = ct.getClassTypeById(id);
		if(ClassType.isPresent()) {
			return new ResponseEntity<ClassType>(ClassType.get(), HttpStatus.OK);
		}
		return new ResponseEntity<ClassType>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<ClassType> removeClassType(@PathVariable Long id) {
		try {
			ct.removeClassType(id);
		}catch (Exception e) {
			return new ResponseEntity<ClassType>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<ClassType>(HttpStatus.NO_CONTENT);
	}
}
