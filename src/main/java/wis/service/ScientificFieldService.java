package wis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.ScientificField;
import wis.repository.ScientificFieldRepository;

@Service
public class ScientificFieldService {

    @Autowired
    private ScientificFieldRepository scientificFieldRepository;

    
    public ScientificFieldService() {
    }

    public Iterable<ScientificField> getScientificFields() {
        return scientificFieldRepository.findAll();
    }

    public Optional<ScientificField> getScientificFieldById(Long id) {
        return scientificFieldRepository.findById(id);
    }

    public void addScientificField(ScientificField scientificField) {
    	scientificFieldRepository.save(scientificField);
    }

    public void removeScientificField(Long id) {
        Optional<ScientificField> scientificField = scientificFieldRepository.findById(id);
        scientificFieldRepository.delete(scientificField.get());
    }

    public void updateScientificField(Long id, ScientificField scientificField) {
        Optional<ScientificField> upScientificField = scientificFieldRepository.findById(id);
        if(upScientificField.isPresent()) {
            scientificField.setId(upScientificField.get().getId());
            scientificFieldRepository.save(scientificField);
        }
    }
	
}
