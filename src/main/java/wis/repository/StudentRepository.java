package wis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wis.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	List<Student> findByFirstNameLike(String firstName);
	List<Student> findByCourseAttendingsCourseRealizationCourseTitle(String courseTitle);
	Student findFirstByCardNumber(String cardNumber);
	//Student findByJMBG (String jMBG);
	List<Student> findByCourseAttendingsFinalGradeLike(int grade);
}
