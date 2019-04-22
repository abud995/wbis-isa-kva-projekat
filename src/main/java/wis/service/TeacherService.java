package wis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Teacher;
import wis.repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	TeacherRepository teacherRepository;
	
	//public Teacher findByJMBG (String jMBG) {
		
		//return teacherRepository.findByJMBG(jMBG);
		
	//}
	
	public List<Teacher> findByFirstName (String firstName) {
		
		return teacherRepository.findByFirstNameLike(firstName);
		
	}
	
}
