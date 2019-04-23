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

import wis.domain.Result;
import wis.service.ResultService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/result")
public class ResultController {

	@Autowired
	ResultService rs;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<Result>> getResults() {
		return new ResponseEntity<Iterable<Result>>(rs.getResults(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Result> addResult(@RequestBody Result Result) {
		rs.addResult(Result);
		return new ResponseEntity<Result>(Result, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Result> updateResult(@PathVariable Long id, @RequestBody Result Result) {
		rs.updateResult(id, Result);
		return new ResponseEntity<Result>(Result, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Result> getResultById(@PathVariable Long id) {
		Optional<Result> Result = rs.getResultById(id);
		if(Result.isPresent()) {
			return new ResponseEntity<Result>(Result.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Result>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Result> removeResult(@PathVariable Long id) {
		try {
			rs.removeResult(id);
		}catch (Exception e) {
			return new ResponseEntity<Result>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Result>(HttpStatus.NO_CONTENT);
	}
}
