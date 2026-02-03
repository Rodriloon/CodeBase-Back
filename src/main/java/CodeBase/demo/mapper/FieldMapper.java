package CodeBase.demo.mapper;

import CodeBase.demo.dto.field.FieldDTO;
import CodeBase.demo.dto.field.FieldResponseDTO;
import CodeBase.demo.model.Field;

public class FieldMapper {

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

    public static FieldResponseDTO toDto(Field entity) {
        return FieldResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .capacity(entity.getCapacity())
                .surface(entity.getSurface())
                .isIndoor(entity.isIndoor())
                .status(entity.getStatus())
                .build();
    }

    public static FieldResponseDTO toDtoWithComplex(Field entity) {
        return FieldResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .capacity(entity.getCapacity())
                .surface(entity.getSurface())
                .isIndoor(entity.isIndoor())
                .status(entity.getStatus())
                .complex(ComplexMapper.toDto(entity.getComplex()))
                .build();
    }
}
