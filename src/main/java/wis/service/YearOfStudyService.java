package wis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.YearOfStudy;
import wis.repository.YearOfStudyRepository;

@Service
public class YearOfStudyService {

    @Autowired
    private YearOfStudyRepository yearOfStudyRepository;

    
    public YearOfStudyService() {
    }

    public Iterable<YearOfStudy> getYearOfStudyes() {
        return yearOfStudyRepository.findAll();
    }

    public Optional<YearOfStudy> getYearOfStudyById(Long id) {
        return yearOfStudyRepository.findById(id);
    }

    public void addYearOfStudy(YearOfStudy yearOfStudy) {
    	yearOfStudyRepository.save(yearOfStudy);
    }

    public void removeYearOfStudy(Long id) {
        Optional<YearOfStudy> yearOfStudy = yearOfStudyRepository.findById(id);
        yearOfStudyRepository.delete(yearOfStudy.get());
    }

    public void updateYearOfStudy(Long id, YearOfStudy yearOfStudy) {
        Optional<YearOfStudy> upYearOfStudy = yearOfStudyRepository.findById(id);
        if(upYearOfStudy.isPresent()) {
            yearOfStudy.setId(upYearOfStudy.get().getId());
            yearOfStudyRepository.save(yearOfStudy);
        }
    }
	
}
