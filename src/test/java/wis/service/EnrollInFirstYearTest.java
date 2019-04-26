package wis.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import wis.domain.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EnrollInFirstYearTest {

	@Autowired
	StudentService studentService;
	
//	@Test
//	@Transactional
//	@Rollback(true)
//	public void test() {
//		Student student = studentService.findByCardNumber("123");
//		studentService.enrolleInFirstYear(student);
//		Student student1 = studentService.findByCardNumber("123");
//		assertEquals(1, student1.getStudentYears().iterator().next().getYearOfStudy().getYear());
//	}
}
