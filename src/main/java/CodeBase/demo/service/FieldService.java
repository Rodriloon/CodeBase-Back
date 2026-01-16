package CodeBase.demo.service;

import CodeBase.demo.exception.FieldNotFound;
import CodeBase.demo.model.Field;

import java.util.List;

import CodeBase.demo.repository.FieldRepository;
import org.springframework.stereotype.Service;

@Service
public class FieldService {

    private final FieldRepository fieldRepository;

    public FieldService(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    public List<Field> getAllFields() {
        return fieldRepository.findAll();
    }

    public Field getField(Long id) {
        return fieldRepository.findById(id).orElseThrow(() -> new FieldNotFound(id));
    }

    public Field create(Field field) {
        return fieldRepository.save(field);
    }
    
    public Field update(Long id, Field fieldDetails) {
        Field field = getField(id);
        field.setName(fieldDetails.getName());
        field.setDescription(fieldDetails.getDescription());
        field.setCapacity(fieldDetails.getCapacity());
        field.setSurface(fieldDetails.getSurface());
        field.setIndoor(fieldDetails.isIndoor());
        field.setStatus(fieldDetails.getStatus());
        return fieldRepository.save(field);
    }

    public void delete(Long id) {
        Field field = getField(id);
        fieldRepository.delete(field);
    }
}
