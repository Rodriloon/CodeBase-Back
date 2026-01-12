package CodeBase.demo.dto;

import jakarta.validation.constraints.NotBlank;
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
public class ResourceDTO {
    
    private Long id; // Useful for updates/responses

    @NotBlank(message = "El nombre del recurso es obligatorio")
    private String name;
    
    private String description;
    
    @NotBlank(message = "El tipo de recurso es obligatorio")
    private String type;
    
    private String status;
}
