package wis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wis.domain.CallingType;

@Repository
public interface CallingTypeRepository extends JpaRepository<CallingType, Long> {

}
