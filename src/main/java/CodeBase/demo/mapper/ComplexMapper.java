package CodeBase.demo.mapper;


import CodeBase.demo.dto.complex.ComplexDTO;
import CodeBase.demo.dto.complex.ComplexResponseDTO;
import CodeBase.demo.model.Complex;

public class ComplexMapper {
    private ComplexMapper() {}

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
}
