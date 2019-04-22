package wis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wis.domain.CourseAttending;

@Repository
public interface CourseAttendingRepository extends JpaRepository<CourseAttending, Long> {

}
