package CodeBase.demo.dto.field;

import CodeBase.demo.model.Field;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FieldResponseDTO {

    private Long id;

    @NotBlank(message = "El nombre de la cancha es obligatorio")
    private String name;

    private String description;

    @NotNull(message = "La capacidad es obligatoria (ej: 5, 7, 11)")
    private Integer capacity;

    @NotNull(message = "El tipo de superficie es obligatorio")
    private Field.SurfaceType surface;

    private boolean isIndoor;

    private Field.FieldStatus status;
}
