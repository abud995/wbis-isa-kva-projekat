package wis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.University;
import wis.repository.UniversityRepository;

@Service
public class UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    
    public UniversityService() {
    }

    public Iterable<University> getUniversities() {
        return universityRepository.findAll();
    }

    public Optional<University> getUniversityById(Long id) {
        return universityRepository.findById(id);
    }

    public void addUniversity(University university) {
    	universityRepository.save(university);
    }

    public void removeUniversity(Long id) {
        Optional<University> university = universityRepository.findById(id);
        universityRepository.delete(university.get());
    }

    public void updateUniversity(Long id, University university) {
        Optional<University> upUniversity = universityRepository.findById(id);
        if(upUniversity.isPresent()) {
            university.setId(upUniversity.get().getId());
            universityRepository.save(university);
        }
    }
	
}
