package CodeBase.demo.dto.reservation;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationDTO {
    @NotNull(message = "El ID de la cancha es obligatorio")
    private Long fieldId;

    @NotNull(message = "La fecha de inicio es obligatoria")
    @Future(message = "La reserva debe ser en una fecha futura")
    private LocalDateTime startAt;
}
