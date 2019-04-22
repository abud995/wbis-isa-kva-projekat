package wis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Course;
import wis.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;
	
	public List<Course> findAll(){
		return courseRepository.findAll();
	}
	
	public List<Course> findByFirstName (String title) {
		
		return courseRepository.findByTitleLike(title);
		
	}
	
    
    public CourseService() {
    }

    public Iterable<Course> getCoursees() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public void addCourse(Course course) {
    	courseRepository.save(course);
    }

    public void removeCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        courseRepository.delete(course.get());
    }

    public void updateCourse(Long id, Course course) {
        Optional<Course> upCourse = courseRepository.findById(id);
        if(upCourse.isPresent()) {
            course.setId(upCourse.get().getId());
            courseRepository.save(course);
        }
    }

}
