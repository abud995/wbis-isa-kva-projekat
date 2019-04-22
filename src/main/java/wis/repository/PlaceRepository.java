package wis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wis.domain.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

}
