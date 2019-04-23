package wis.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import wis.domain.StudyProgram;
import wis.service.StudyProgramService;
import wis.utils.View.HideOptionalProperties;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/studyprogram")
public class StudyProgramController {

	@Autowired
	StudyProgramService sps;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<StudyProgram>> getStudyPrograms() {
		return new ResponseEntity<Iterable<StudyProgram>>(sps.getStudyPrograms(), HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<StudyProgram> addStudyProgram(@RequestBody StudyProgram StudyProgram) {
		sps.addStudyProgram(StudyProgram);
		return new ResponseEntity<StudyProgram>(StudyProgram, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<StudyProgram> updateStudyProgram(@PathVariable Long id, @RequestBody StudyProgram StudyProgram) {
		sps.updateStudyProgram(id, StudyProgram);
		return new ResponseEntity<StudyProgram>(StudyProgram, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<StudyProgram> getStudyProgramById(@PathVariable Long id) {
		Optional<StudyProgram> StudyProgram = sps.getStudyProgramById(id);
		if(StudyProgram.isPresent()) {
			return new ResponseEntity<StudyProgram>(StudyProgram.get(), HttpStatus.OK);
		}
		return new ResponseEntity<StudyProgram>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<StudyProgram> removeStudyProgram(@PathVariable Long id) {
		try {
			sps.removeStudyProgram(id);
		}catch (Exception e) {
			return new ResponseEntity<StudyProgram>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<StudyProgram>(HttpStatus.NO_CONTENT);
	}
}
