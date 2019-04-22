package wis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wis.domain.CourseRealization;

@Repository
public interface CourseRealizationRepository extends JpaRepository<CourseRealization, Long> {

}
