package CodeBase.demo.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
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
public class BookingDTO {
    
    private Long id;

    @NotNull(message = "La fecha de inicio es obligatoria")
    @FutureOrPresent(message = "La reserva debe ser en el futuro o presente")
    private LocalDateTime startTime;

    @NotNull(message = "La fecha de fin es obligatoria")
    private LocalDateTime endTime;

    @NotNull(message = "El ID de la cancha es obligatorio")
    private Long fieldId;

    @NotBlank(message = "El nombre del cliente es obligatorio")
    private String customerName;
    
    private String status;
}
