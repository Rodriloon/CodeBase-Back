package CodeBase.demo.controller;

import CodeBase.demo.dto.field.FieldDTO;
import CodeBase.demo.dto.field.FieldResponseDTO;
import CodeBase.demo.service.FieldService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fields")
@CrossOrigin(origins = "*")
public class FieldController {

    private final FieldService fieldService;

    public FieldController(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    @GetMapping
    public ResponseEntity<List<FieldResponseDTO>> getAllFields() {
        return ResponseEntity.ok(fieldService.getAllFields());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FieldResponseDTO> getField(@PathVariable Long id) {
        return ResponseEntity.ok(fieldService.getField(id));
    }

    @PostMapping
    public ResponseEntity<FieldResponseDTO> create(@Valid @RequestBody FieldDTO dto) {
        FieldResponseDTO saved = fieldService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FieldResponseDTO> update(@PathVariable Long id, @Valid @RequestBody FieldDTO dto) {
        return ResponseEntity.ok(fieldService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fieldService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
