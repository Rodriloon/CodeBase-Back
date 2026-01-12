package CodeBase.demo.service;

import CodeBase.demo.exception.ResourceNotFound;
import CodeBase.demo.model.Resource;
import CodeBase.demo.repository.ResourceRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {

    private final ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    public Resource getResource(Long id) {
        return resourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound(id));
    }

    public Resource create(Resource resource) {
        return resourceRepository.save(resource);
    }
    
    public Resource update(Long id, Resource resourceDetails) {
        Resource resource = getResource(id);
        resource.setName(resourceDetails.getName());
        resource.setDescription(resourceDetails.getDescription());
        resource.setType(resourceDetails.getType());
        resource.setStatus(resourceDetails.getStatus());
        return resourceRepository.save(resource);
    }

    public void delete(Long id) {
        Resource resource = getResource(id);
        resourceRepository.delete(resource);
    }
}
