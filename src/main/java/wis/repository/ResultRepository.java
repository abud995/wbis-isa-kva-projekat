package wis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wis.domain.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

}
