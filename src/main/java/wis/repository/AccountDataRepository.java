package wis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wis.domain.AccountData;

@Repository
public interface AccountDataRepository extends JpaRepository<AccountData, Long> {

}
