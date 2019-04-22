package wis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.Calling;
import wis.repository.CallingRepository;

@Service
public class CallingService {
	
    @Autowired
    private CallingRepository callingRepository;

    
    public CallingService() {
    }

    public Iterable<Calling> getCallinges() {
        return callingRepository.findAll();
    }

    public Optional<Calling> getCallingById(Long id) {
        return callingRepository.findById(id);
    }

    public void addCalling(Calling calling) {
    	callingRepository.save(calling);
    }

    public void removeCalling(Long id) {
        Optional<Calling> calling = callingRepository.findById(id);
        callingRepository.delete(calling.get());
    }

    public void updateCalling(Long id, Calling calling) {
        Optional<Calling> upCalling = callingRepository.findById(id);
        if(upCalling.isPresent()) {
            calling.setId(upCalling.get().getId());
            callingRepository.save(calling);
        }
    }
	
}
