package wis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Teacher;
import wis.repository.TeacherRepository;


@Service
public class TeacherService {

	@Autowired
	TeacherRepository teacherRepository;
	


    
    public TeacherService() {
    }

    public Iterable<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    public void addTeacher(Teacher teacher) {
    	teacherRepository.save(teacher);
    }

    public void removeTeacher(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        teacherRepository.delete(teacher.get());
    }

    public void updateTeacher(Long id, Teacher teacher) {
        Optional<Teacher> upTeacher = teacherRepository.findById(id);
        if(upTeacher.isPresent()) {
            teacher.setId(upTeacher.get().getId());
            teacherRepository.save(teacher);
        }
    }
	
	
	//public Teacher findByJMBG (String jMBG) {
		
		//return teacherRepository.findByJMBG(jMBG);
		
	//}
	
	public List<Teacher> findByFirstName (String firstName) {
		
		return teacherRepository.findByFirstNameLike(firstName);
		
	}
	
}
