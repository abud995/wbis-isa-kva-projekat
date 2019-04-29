package wis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wis.domain.Student;
import wis.domain.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>, TeacherRepositoryCustom {

	//List<Teacher> findByFirstNameLike(String firstName);
	//Teacher findByJMBG (String jMBG);
}
