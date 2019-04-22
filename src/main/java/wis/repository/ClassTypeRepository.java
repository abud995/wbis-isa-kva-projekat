package wis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wis.domain.ClassType;

@Repository
public interface ClassTypeRepository extends JpaRepository<ClassType, Long> {

}
