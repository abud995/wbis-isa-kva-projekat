package wis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Country;
import wis.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    
    public CountryService() {
    }

    public Iterable<Country> getCountrys() {
        return countryRepository.findAll();
    }

    public Optional<Country> getCountryById(Long id) {
        return countryRepository.findById(id);
    }

    public void addCountry(Country country) {
    	countryRepository.save(country);
    }

    public void removeCountry(Long id) {
        Optional<Country> country = countryRepository.findById(id);
        countryRepository.delete(country.get());
    }

    public void updateCountry(Long id, Country country) {
        Optional<Country> upCountry = countryRepository.findById(id);
        if(upCountry.isPresent()) {
            country.setId(upCountry.get().getId());
            countryRepository.save(country);
        }
    }
	
}
