package CodeBase.demo.service;

import CodeBase.demo.dto.field.FieldDTO;
import CodeBase.demo.dto.field.FieldResponseDTO;
import CodeBase.demo.exception.FieldNotFound;
import CodeBase.demo.mapper.FieldMapper;
import CodeBase.demo.model.Complex;
import CodeBase.demo.model.Field;

import java.util.List;

import CodeBase.demo.repository.ComplexRepository;
import CodeBase.demo.repository.FieldRepository;
import org.springframework.stereotype.Service;

@Service
public class FieldService {

    private final FieldRepository fieldRepository;
    private final ComplexRepository complexRepository;

    public FieldService(FieldRepository fieldRepository, ComplexRepository complexRepository) {
        this.fieldRepository = fieldRepository;
        this.complexRepository = complexRepository;
    }

    public List<FieldResponseDTO> getAllFields() {
        return fieldRepository.findAll()
                .stream()
                .map(FieldMapper::toDto)
                .toList();
    }

    public FieldResponseDTO getField(Long id) {
        Field field = fieldRepository.findById(id)
                .orElseThrow(() -> new FieldNotFound(id));
        return FieldMapper.toDto(field);
    }

    public FieldResponseDTO create(FieldDTO dto) {
        Complex complex = complexRepository.findById(dto.getComplexId())
                .orElseThrow(() -> new RuntimeException("Complejo no encontrado"));
        Field field = FieldMapper.toEntity(dto);
        field.setComplex(complex);
        Field saved = fieldRepository.save(field);
        return FieldMapper.toDto(saved);
    }

    public FieldResponseDTO update(Long id, FieldDTO dto) {
        Field fieldDetails = FieldMapper.toEntity(dto);
        Field field = fieldRepository.findById(id)
                .orElseThrow(() -> new FieldNotFound(id));

        field.setName(fieldDetails.getName());
        field.setDescription(fieldDetails.getDescription());
        field.setCapacity(fieldDetails.getCapacity());
        field.setSurface(fieldDetails.getSurface());
        field.setIndoor(fieldDetails.isIndoor());
        field.setStatus(fieldDetails.getStatus());

        Field updated = fieldRepository.save(field);
        return FieldMapper.toDto(updated);
    }

    public void delete(Long id) {
        Field field = fieldRepository.findById(id)
                .orElseThrow(() -> new FieldNotFound(id));
        fieldRepository.delete(field);
    }
}