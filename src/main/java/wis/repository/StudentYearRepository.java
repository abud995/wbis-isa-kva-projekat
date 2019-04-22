package wis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wis.domain.StudentYear;

@Repository
public interface StudentYearRepository extends JpaRepository<StudentYear, Long> {

}
