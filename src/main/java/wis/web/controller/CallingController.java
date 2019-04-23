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

import wis.domain.Calling;
import wis.service.CallingService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/calling")
public class CallingController {
	

	@Autowired
	CallingService cs;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<Calling>> getCallings() {
		return new ResponseEntity<Iterable<Calling>>(cs.getCallings(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Calling> addACalling(@RequestBody Calling Calling) {
		cs.addCalling(Calling);
		return new ResponseEntity<Calling>(Calling, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Calling> updateCalling(@PathVariable Long id, @RequestBody Calling Calling) {
		cs.updateCalling(id, Calling);
		return new ResponseEntity<Calling>(Calling, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Calling> getCallingById(@PathVariable Long id) {
		Optional<Calling> Calling = cs.getCallingById(id);
		if(Calling.isPresent()) {
			return new ResponseEntity<Calling>(Calling.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Calling>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Calling> removeAddress(@PathVariable Long id) {
		try {
			cs.removeCalling(id);
		}catch (Exception e) {
			return new ResponseEntity<Calling>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Calling>(HttpStatus.NO_CONTENT);
	}

}
