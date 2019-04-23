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

import wis.domain.Place;
import wis.service.PlaceService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/place")
public class PlaceController {
	@Autowired
	PlaceService ps;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<Place>> getCourses() {
		return new ResponseEntity<Iterable<Place>>(ps.getPlaces(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Place> addPlace(@RequestBody Place Place) {
		ps.addPlace(Place);
		return new ResponseEntity<Place>(Place, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Place> updatePlace(@PathVariable Long id, @RequestBody Place Place) {
		ps.updatePlace(id, Place);
		return new ResponseEntity<Place>(Place, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Place> getPlaceById(@PathVariable Long id) {
		Optional<Place> Place = ps.getPlaceById(id);
		if(Place.isPresent()) {
			return new ResponseEntity<Place>(Place.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Place>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Place> removeCourse(@PathVariable Long id) {
		try {
			ps.removePlace(id);
		}catch (Exception e) {
			return new ResponseEntity<Place>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Place>(HttpStatus.NO_CONTENT);
	}
}
