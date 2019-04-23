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

import wis.domain.Country;
import wis.service.CountryService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/country")
public class CountryController {

	@Autowired
	CountryService cs;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<Country>> getCountry() {
		return new ResponseEntity<Iterable<Country>>(cs.getCountrys(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Country> addCountry(@RequestBody Country Country) {
		cs.addCountry(Country);
		return new ResponseEntity<Country>(Country, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Country Country) {
		cs.updateCountry(id, Country);
		return new ResponseEntity<Country>(Country, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
		Optional<Country> Country = cs.getCountryById(id);
		if(Country.isPresent()) {
			return new ResponseEntity<Country>(Country.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Country> removeCountry(@PathVariable Long id) {
		try {
			cs.removeCountry(id);
		}catch (Exception e) {
			return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Country>(HttpStatus.NO_CONTENT);
	}
}
