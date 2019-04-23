package wis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.CallingType;
import wis.repository.CallingTypeRepository;

@Service
public class CallingTypeService {

    @Autowired
    private CallingTypeRepository callingTypeRepository;

    
    public CallingTypeService() {
    }

    public Iterable<CallingType> getCallingTypes() {
        return callingTypeRepository.findAll();
    }

    public Optional<CallingType> getCallingTypeById(Long id) {
        return callingTypeRepository.findById(id);
    }

    public void addCallingType(CallingType callingType) {
    	callingTypeRepository.save(callingType);
    }

    public void removeCallingType(Long id) {
        Optional<CallingType> callingType = callingTypeRepository.findById(id);
        callingTypeRepository.delete(callingType.get());
    }

    public void updateCallingType(Long id, CallingType callingType) {
        Optional<CallingType> upCallingType = callingTypeRepository.findById(id);
        if(upCallingType.isPresent()) {
            callingType.setId(upCallingType.get().getId());
            callingTypeRepository.save(callingType);
        }
    }
	
	
}
