package CodeBase.demo.dto.field;

import CodeBase.demo.model.Field;
import CodeBase.demo.model.Field.SurfaceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FieldDTO {
    @NotBlank(message = "El nombre de la cancha es obligatorio")
    private String name;
    
    private String description;
    
    @NotNull(message = "La capacidad es obligatoria (ej: 5, 7, 11)")
    private Integer capacity;
    
    @NotNull(message = "El tipo de superficie es obligatorio")
    private SurfaceType surface;
    
    private boolean isIndoor;
    
    private Field.FieldStatus status;
    private Long complexId;
}
