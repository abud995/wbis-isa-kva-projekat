package wis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.CourseRealization;
import wis.repository.CourseRealizationRepository;

@Service
public class CourseRealizationService {

    @Autowired
    private CourseRealizationRepository courseRealizationRepository;

    
    public CourseRealizationService() {
    }

    public Iterable<CourseRealization> getCourseRealizationes() {
        return courseRealizationRepository.findAll();
    }

    public Optional<CourseRealization> getCourseRealizationById(Long id) {
        return courseRealizationRepository.findById(id);
    }

    public void addCourseRealization(CourseRealization courseRealization) {
    	courseRealizationRepository.save(courseRealization);
    }

    public void removeCourseRealization(Long id) {
        Optional<CourseRealization> courseRealization = courseRealizationRepository.findById(id);
        courseRealizationRepository.delete(courseRealization.get());
    }

    public void updateCourseRealization(Long id, CourseRealization courseRealization) {
        Optional<CourseRealization> upCourseRealization = courseRealizationRepository.findById(id);
        if(upCourseRealization.isPresent()) {
            courseRealization.setId(upCourseRealization.get().getId());
            courseRealizationRepository.save(courseRealization);
        }
    }
	
}
