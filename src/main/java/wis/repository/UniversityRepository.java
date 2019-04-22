package wis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wis.domain.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {

}
