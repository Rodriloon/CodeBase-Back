package CodeBase.demo.controller;

import CodeBase.demo.dto.complex.ComplexDTO;
import CodeBase.demo.dto.complex.ComplexResponseDTO;
import CodeBase.demo.model.User;
import CodeBase.demo.service.ComplexService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/complexes")
@CrossOrigin(origins = "*")
public class ComplexController {

    private final ComplexService complexService;

    public ComplexController(ComplexService complexService) {
        this.complexService = complexService;
    }

    @PostMapping
    public ResponseEntity<ComplexResponseDTO> create(
            @AuthenticationPrincipal User user,
            @Valid @RequestBody ComplexDTO complexDto) {
        ComplexResponseDTO response = complexService.create(user, complexDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/me")
    public ResponseEntity<List<ComplexResponseDTO>> getComplexesByAdmin(
            @AuthenticationPrincipal User user) {

        List<ComplexResponseDTO> complexes = complexService.getComplexesByAdmin(user);
        return ResponseEntity.ok(complexes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComplexResponseDTO> getComplex(@PathVariable Long id) {
        ComplexResponseDTO complex = complexService.getComplex(id);
        return ResponseEntity.ok(complex);
    }

}