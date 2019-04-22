package wis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.CourseAttending;
import wis.repository.CourseAttendingRepository;

@Service
public class CourseAttendingService {

    @Autowired
    private CourseAttendingRepository courseAttendingRepository;

    
    public CourseAttendingService() {
    }

    public Iterable<CourseAttending> getCourseAttendinges() {
        return courseAttendingRepository.findAll();
    }

    public Optional<CourseAttending> getCourseAttendingById(Long id) {
        return courseAttendingRepository.findById(id);
    }

    public void addCourseAttending(CourseAttending courseAttending) {
    	courseAttendingRepository.save(courseAttending);
    }

    public void removeCourseAttending(Long id) {
        Optional<CourseAttending> courseAttending = courseAttendingRepository.findById(id);
        courseAttendingRepository.delete(courseAttending.get());
    }

    public void updateCourseAttending(Long id, CourseAttending courseAttending) {
        Optional<CourseAttending> upCourseAttending = courseAttendingRepository.findById(id);
        if(upCourseAttending.isPresent()) {
            courseAttending.setId(upCourseAttending.get().getId());
            courseAttendingRepository.save(courseAttending);
        }
    }
	
}
