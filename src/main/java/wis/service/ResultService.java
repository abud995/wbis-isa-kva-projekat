package wis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Result;
import wis.repository.ResultRepository;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    
    public ResultService() {
    }

    public Iterable<Result> getResults() {
        return resultRepository.findAll();
    }

    public Optional<Result> getResultById(Long id) {
        return resultRepository.findById(id);
    }

    public void addResult(Result result) {
    	resultRepository.save(result);
    }

    public void removeResult(Long id) {
        Optional<Result> result = resultRepository.findById(id);
        resultRepository.delete(result.get());
    }

    public void updateResult(Long id, Result result) {
        Optional<Result> upResult = resultRepository.findById(id);
        if(upResult.isPresent()) {
            result.setId(upResult.get().getId());
            resultRepository.save(result);
        }
    }
	
}
