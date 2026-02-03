package CodeBase.demo.dto.field;

import CodeBase.demo.dto.complex.ComplexResponseDTO;
import CodeBase.demo.model.Field;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FieldResponseDTO {

    private Long id;
    private String name;
    private String description;
    private Integer capacity;
    private Field.SurfaceType surface;
    private boolean isIndoor;
    private Field.FieldStatus status;
    private ComplexResponseDTO complex;
}
