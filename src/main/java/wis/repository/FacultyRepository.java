package wis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wis.domain.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

}
