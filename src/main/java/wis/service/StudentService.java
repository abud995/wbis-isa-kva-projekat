package wis.service;

import java.util.List;
import java.util.Optional;

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
	
	
    
    public StudentService() {
    }

    public Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public void addStudent(Student student) {
    	studentRepository.save(student);
    }

    public void removeStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        studentRepository.delete(student.get());
    }

    public void updateStudent(Long id, Student student) {
        Optional<Student> upStudent = studentRepository.findById(id);
        if(upStudent.isPresent()) {
            student.setId(upStudent.get().getId());
            studentRepository.save(student);
        }
    }
	
	public void enrolleInFirstYear(Student student) {
		YearOfStudy yearOfStudy = yearOfStudyRepository.findFirstByYear(1);
		StudentYear studentYear = new StudentYear();
		studentYear.setYearOfStudy(yearOfStudy);
		student.getStudentYears().add(studentYear);
		studentRepository.save(student);
	}
	
	//public Student findByCardNumber(String cardNumber) {
		//return studentRepository.findFirstByCardNumber(cardNumber);
	//}

	//public Student findByJMBG (String jMBG) {
		
		//return studentRepository.findByJMBG(jMBG);
		
	//}
	
//	public List<Student> findByFirstName (String firstName) {
//		
//		return studentRepository.findByFirstNameLike(firstName);
//		
//	}
//	
//	public List<Student> findByFinalGrade (int grade){
//		
//		return studentRepository.findByCourseAttendingsFinalGradeLike(grade);
//		
//	}
	
}
