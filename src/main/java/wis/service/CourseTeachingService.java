package wis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.CourseTeaching;
import wis.repository.CourseTeachingRepository;

@Service
public class CourseTeachingService {

    @Autowired
    private CourseTeachingRepository courseTeachingRepository;

    
    public CourseTeachingService() {
    }

    public Iterable<CourseTeaching> getCourseTeachinges() {
        return courseTeachingRepository.findAll();
    }

    public Optional<CourseTeaching> getCourseTeachingById(Long id) {
        return courseTeachingRepository.findById(id);
    }

    public void addCourseTeaching(CourseTeaching courseTeaching) {
    	courseTeachingRepository.save(courseTeaching);
    }

    public void removeCourseTeaching(Long id) {
        Optional<CourseTeaching> courseTeaching = courseTeachingRepository.findById(id);
        courseTeachingRepository.delete(courseTeaching.get());
    }

    public void updateCourseTeaching(Long id, CourseTeaching courseTeaching) {
        Optional<CourseTeaching> upCourseTeaching = courseTeachingRepository.findById(id);
        if(upCourseTeaching.isPresent()) {
            courseTeaching.setId(upCourseTeaching.get().getId());
            courseTeachingRepository.save(courseTeaching);
        }
    }
	
}
