package wis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.StudyProgram;
import wis.repository.StudyProgramRepository;

@Service
public class StudyProgramService {

    @Autowired
    private StudyProgramRepository studyProgramRepository;

    
    public StudyProgramService() {
    }

    public Iterable<StudyProgram> getStudyProgrames() {
        return studyProgramRepository.findAll();
    }

    public Optional<StudyProgram> getStudyProgramById(Long id) {
        return studyProgramRepository.findById(id);
    }

    public void addStudyProgram(StudyProgram studyProgram) {
    	studyProgramRepository.save(studyProgram);
    }

    public void removeStudyProgram(Long id) {
        Optional<StudyProgram> studyProgram = studyProgramRepository.findById(id);
        studyProgramRepository.delete(studyProgram.get());
    }

    public void updateStudyProgram(Long id, StudyProgram studyProgram) {
        Optional<StudyProgram> upStudyProgram = studyProgramRepository.findById(id);
        if(upStudyProgram.isPresent()) {
            studyProgram.setId(upStudyProgram.get().getId());
            studyProgramRepository.save(studyProgram);
        }
    }
	
}
