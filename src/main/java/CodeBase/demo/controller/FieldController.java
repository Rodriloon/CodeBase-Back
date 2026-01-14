package CodeBase.demo.controller;

import CodeBase.demo.dto.FieldDTO;
import CodeBase.demo.mapper.FieldMapper;
import CodeBase.demo.model.Field;
import CodeBase.demo.service.FieldService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fields")
public class FieldController {
    
    private final FieldService fieldService;

    public FieldController(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    @GetMapping
    public ResponseEntity<List<FieldDTO>> getAllFields() {
        List<FieldDTO> fields = fieldService.getAllFields().stream()
                .map(FieldMapper::toDto)
                .toList();
        return ResponseEntity.ok(fields);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FieldDTO> getField(@PathVariable Long id) {
        FieldDTO field = FieldMapper.toDto(fieldService.getField(id));
        return ResponseEntity.ok(field);
    }

    @PostMapping
    public ResponseEntity<FieldDTO> create(@Valid @RequestBody FieldDTO dto) {
        Field field = FieldMapper.toEntity(dto);
        Field saved = fieldService.create(field);
        return ResponseEntity.status(HttpStatus.CREATED).body(FieldMapper.toDto(saved));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<FieldDTO> update(@PathVariable Long id, @Valid @RequestBody FieldDTO dto) {
        Field field = FieldMapper.toEntity(dto);
        Field updated = fieldService.update(id, field);
        return ResponseEntity.ok(FieldMapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fieldService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
