package CodeBase.demo.mapper;

import CodeBase.demo.dto.FieldDTO;
import CodeBase.demo.model.Field;

public class FieldMapper {

    private FieldMapper() {}

    public static Field toEntity(FieldDTO dto) {
        return Field.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .capacity(dto.getCapacity())
                .surface(dto.getSurface())
                .isIndoor(dto.isIndoor())
                .status(dto.getStatus())
                .build();
    }

    public static FieldDTO toDto(Field entity) {
        return FieldDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .capacity(entity.getCapacity())
                .surface(entity.getSurface())
                .isIndoor(entity.isIndoor())
                .status(entity.getStatus())
                .build();
    }
}
