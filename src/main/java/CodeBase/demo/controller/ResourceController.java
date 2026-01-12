package CodeBase.demo.controller;

import CodeBase.demo.dto.ResourceDTO;
import CodeBase.demo.mapper.ResourceMapper;
import CodeBase.demo.model.Resource;
import CodeBase.demo.service.ResourceService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/resources")
public class ResourceController {
    
    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping
    public ResponseEntity<List<ResourceDTO>> getAllResources() {
        List<ResourceDTO> resources = resourceService.getAllResources().stream()
                .map(ResourceMapper::toDto)
                .toList();
        return ResponseEntity.ok(resources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceDTO> getResource(@PathVariable Long id) {
        ResourceDTO resource = ResourceMapper.toDto(resourceService.getResource(id));
        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<ResourceDTO> create(@Valid @RequestBody ResourceDTO dto) {
        Resource resource = ResourceMapper.toEntity(dto);
        Resource saved = resourceService.create(resource);
        return ResponseEntity.status(HttpStatus.CREATED).body(ResourceMapper.toDto(saved));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ResourceDTO> update(@PathVariable Long id, @Valid @RequestBody ResourceDTO dto) {
        Resource resource = ResourceMapper.toEntity(dto);
        Resource updated = resourceService.update(id, resource);
        return ResponseEntity.ok(ResourceMapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        resourceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
