package CodeBase.demo.dto.reservation;

import CodeBase.demo.dto.field.FieldResponseDTO;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationResponseDTO {
    private Long id;
    private LocalDateTime startAt;
    private FieldResponseDTO field;
}
