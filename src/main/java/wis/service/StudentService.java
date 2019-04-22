package wis.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Student;
import wis.domain.StudentYear;
import wis.domain.YearOfStudy;
import wis.repository.StudentRepository;
import wis.repository.YearOfStudyRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	YearOfStudyRepository yearOfStudyRepository;
	
	public void enrolleInFirstYear(Student student) {
		YearOfStudy yearOfStudy = yearOfStudyRepository.findFirstByNumberOfYear(1);
		StudentYear studentYear = new StudentYear();
		studentYear.setYearOfStudy(yearOfStudy);
		student.getStudentYears().add(studentYear);
		studentRepository.save(student);
	}
	
	public Student findByCardNumber(String cardNumber) {
		return studentRepository.findFirstByCardNumber(cardNumber);
	}

	//public Student findByJMBG (String jMBG) {
		
		//return studentRepository.findByJMBG(jMBG);
		
	//}
	
	public List<Student> findByFirstName (String firstName) {
		
		return studentRepository.findByFirstNameLike(firstName);
		
	}
	
	public List<Student> findByFinalGrade (int grade){
		
		return studentRepository.findByCourseAttendingsFinalGradeLike(grade);
		
	}
	
}
