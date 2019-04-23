package wis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Place;
import wis.repository.PlaceRepository;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    
    public PlaceService() {
    }

    public Iterable<Place> getPlaces() {
        return placeRepository.findAll();
    }

    public Optional<Place> getPlaceById(Long id) {
        return placeRepository.findById(id);
    }

    public void addPlace(Place place) {
    	placeRepository.save(place);
    }

    public void removePlace(Long id) {
        Optional<Place> place = placeRepository.findById(id);
        placeRepository.delete(place.get());
    }

    public void updatePlace(Long id, Place place) {
        Optional<Place> uPlace = placeRepository.findById(id);
        if(uPlace.isPresent()) {
            place.setId(uPlace.get().getId());
            placeRepository.save(place);
        }
    }
	
}
