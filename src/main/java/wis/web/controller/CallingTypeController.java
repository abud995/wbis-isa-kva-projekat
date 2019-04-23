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

import wis.domain.CallingType;
import wis.service.CallingTypeService;
import wis.utils.View.HideOptionalProperties;


@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/callingtype")
public class CallingTypeController {
	
	@Autowired
	CallingTypeService ct;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<CallingType>> getCallingTypes() {
		return new ResponseEntity<Iterable<CallingType>>(ct.getCallingTypes(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<CallingType> addCallingType(@RequestBody CallingType CallingType) {
		ct.addCallingType(CallingType);
		return new ResponseEntity<CallingType>(CallingType, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<CallingType> updateCalling(@PathVariable Long id, @RequestBody CallingType CallingType) {
		ct.updateCallingType(id, CallingType);
		return new ResponseEntity<CallingType>(CallingType, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<CallingType> getCallingById(@PathVariable Long id) {
		Optional<CallingType> CallingType = ct.getCallingTypeById(id);
		if(CallingType.isPresent()) {
			return new ResponseEntity<CallingType>(CallingType.get(), HttpStatus.OK);
		}
		return new ResponseEntity<CallingType>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<CallingType> removeCallingType(@PathVariable Long id) {
		try {
			ct.removeCallingType(id);
		}catch (Exception e) {
			return new ResponseEntity<CallingType>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<CallingType>(HttpStatus.NO_CONTENT);
	}


}
