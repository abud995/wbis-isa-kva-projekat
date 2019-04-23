package wis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis.domain.ClassType;
import wis.repository.ClassTypeRepository;

@Service
public class ClassTypeService {

    @Autowired
    private ClassTypeRepository classTypeRepository;

    
    public ClassTypeService() {
    }

    public Iterable<ClassType> getClassTypes() {
        return classTypeRepository.findAll();
    }

    public Optional<ClassType> getClassTypeById(Long id) {
        return classTypeRepository.findById(id);
    }

    public void addClassType(ClassType classType) {
    	classTypeRepository.save(classType);
    }

    public void removeClassType(Long id) {
        Optional<ClassType> classType = classTypeRepository.findById(id);
        classTypeRepository.delete(classType.get());
    }

    public void updateClassType(Long id, ClassType classType) {
        Optional<ClassType> upClassType = classTypeRepository.findById(id);
        if(upClassType.isPresent()) {
            classType.setId(upClassType.get().getId());
            classTypeRepository.save(classType);
        }
    }
	
}
