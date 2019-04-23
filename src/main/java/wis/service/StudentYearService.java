package wis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.StudentYear;
import wis.repository.StudentYearRepository;

@Service
public class StudentYearService {

    @Autowired
    private StudentYearRepository studentYearRepository;

    
    public StudentYearService() {
    }

    public Iterable<StudentYear> getStudentYears() {
        return studentYearRepository.findAll();
    }

    public Optional<StudentYear> getStudentYearById(Long id) {
        return studentYearRepository.findById(id);
    }

    public void addStudentYear(StudentYear studentYear) {
    	studentYearRepository.save(studentYear);
    }

    public void removeStudentYear(Long id) {
        Optional<StudentYear> studentYear = studentYearRepository.findById(id);
        studentYearRepository.delete(studentYear.get());
    }

    public void updateStudentYear(Long id, StudentYear studentYear) {
        Optional<StudentYear> upStudentYear = studentYearRepository.findById(id);
        if(upStudentYear.isPresent()) {
            studentYear.setId(upStudentYear.get().getId());
            studentYearRepository.save(studentYear);
        }
    }
	
}
