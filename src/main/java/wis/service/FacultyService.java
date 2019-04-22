package wis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Faculty;
import wis.repository.FacultyRepository;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    
    public FacultyService() {
    }

    public Iterable<Faculty> getFacultyes() {
        return facultyRepository.findAll();
    }

    public Optional<Faculty> getFacultyById(Long id) {
        return facultyRepository.findById(id);
    }

    public void addFaculty(Faculty faculty) {
    	facultyRepository.save(faculty);
    }

    public void removeFaculty(Long id) {
        Optional<Faculty> faculty = facultyRepository.findById(id);
        facultyRepository.delete(faculty.get());
    }

    public void updateFaculty(Long id, Faculty faculty) {
        Optional<Faculty> upFaculty = facultyRepository.findById(id);
        if(upFaculty.isPresent()) {
            faculty.setId(upFaculty.get().getId());
            facultyRepository.save(faculty);
        }
    }
	
}
