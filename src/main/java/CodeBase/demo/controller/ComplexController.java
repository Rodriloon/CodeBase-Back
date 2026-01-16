package CodeBase.demo.controller;

import CodeBase.demo.dto.complex.ComplexDTO;
import CodeBase.demo.dto.complex.ComplexResponseDTO;
import CodeBase.demo.mapper.ComplexMapper;
import CodeBase.demo.model.Complex;
import CodeBase.demo.service.ComplexService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/complexes")
@CrossOrigin(origins = "*")
public class ComplexController {

    private final ComplexService complexService;

    public ComplexController(ComplexService complexService) {
        this.complexService = complexService;
    }

    @PostMapping
    public ResponseEntity<ComplexResponseDTO> create(@Valid @RequestBody ComplexDTO dto) {
        Complex complex = ComplexMapper.toEntity(dto);
        Complex saved = complexService.create(complex);
        return ResponseEntity.status(HttpStatus.CREATED).body(ComplexMapper.toDto(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComplexResponseDTO> getComplexById(@PathVariable Long id) {
        ComplexResponseDTO complex = ComplexMapper.toDto(complexService.getComplex(id));
        return ResponseEntity.ok(complex);
    }

}
