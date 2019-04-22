package wis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wis.domain.ScientificField;

@Repository
public interface ScientificFieldRepository extends JpaRepository<ScientificField, Long> {

}
