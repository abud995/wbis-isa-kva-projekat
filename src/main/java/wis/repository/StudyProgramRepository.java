package wis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wis.domain.StudyProgram;

@Repository
public interface StudyProgramRepository extends JpaRepository<StudyProgram, Long> {

}
