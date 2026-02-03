package CodeBase.demo.controller;
import CodeBase.demo.dto.reservation.ReservationDTO;
import CodeBase.demo.dto.reservation.ReservationResponseDTO;
import CodeBase.demo.model.User;
import CodeBase.demo.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservations")
@CrossOrigin(origins = "*")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping()
    public ResponseEntity<ReservationResponseDTO> createReservation(@AuthenticationPrincipal User user, @Valid @RequestBody ReservationDTO reservationDTO) {
        ReservationResponseDTO reservation = reservationService.createReservation(user, reservationDTO);
        return ResponseEntity.ok(reservation);
    }

    @GetMapping("/me")
    public ResponseEntity<List<ReservationResponseDTO>> getReservationsByUser(@AuthenticationPrincipal User user) {
        List<ReservationResponseDTO> reservations = reservationService.getReservationsByUser(user);
        return ResponseEntity.ok(reservations);
    }

}
