package CodeBase.demo.mapper;


import CodeBase.demo.dto.complex.ComplexDTO;
import CodeBase.demo.dto.complex.ComplexResponseDTO;
import CodeBase.demo.model.Complex;

public class ComplexMapper {

    public static Complex toEntity(ComplexDTO dto) {
        return Complex.builder()
                .name(dto.getName())
                .location(dto.getLocation())
                .build();
    }

    public static ComplexResponseDTO toDto(Complex entity) {
        return ComplexResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .location(entity.getLocation())
                .build();
    }

    public static ComplexResponseDTO toDtoWithFields(Complex entity) {
        return ComplexResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .location(entity.getLocation())
                .fields(
                        entity.getFields().stream()
                                .map(FieldMapper::toDto)
                                .toList()
                )
                .build();
    }


}
