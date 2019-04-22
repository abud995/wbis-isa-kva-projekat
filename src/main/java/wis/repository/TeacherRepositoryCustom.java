package wis.repository;

import java.util.List;

import wis.domain.Teacher;

public interface TeacherRepositoryCustom {
	
	List<Teacher> findByLastName(String lastName);
}
