package CodeBase.demo.dto.complex;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComplexDTO {

    @NotBlank(message = "El nombre de la cancha es obligatorio")
    private String name;

    private String location;
}
