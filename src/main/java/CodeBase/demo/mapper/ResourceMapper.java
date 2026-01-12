package CodeBase.demo.mapper;

import CodeBase.demo.dto.ResourceDTO;
import CodeBase.demo.model.Resource;

public class ResourceMapper {

    private ResourceMapper() {}

    public static Resource toEntity(ResourceDTO dto) {
        return Resource.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .type(dto.getType())
                .status(dto.getStatus())
                .build();
    }

    public static ResourceDTO toDto(Resource entity) {
        return ResourceDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .type(entity.getType())
                .status(entity.getStatus())
                .build();
    }
}
