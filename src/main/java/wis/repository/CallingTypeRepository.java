package wis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallingTypeRepository extends JpaRepository<CallingTypeRepository, Long> {

}
