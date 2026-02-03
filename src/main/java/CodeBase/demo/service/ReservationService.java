package CodeBase.demo.service;

import CodeBase.demo.dto.reservation.ReservationDTO;
import CodeBase.demo.dto.reservation.ReservationResponseDTO;
import CodeBase.demo.mapper.ReservationMapper;
import CodeBase.demo.model.Field;
import CodeBase.demo.model.Reservation;
import CodeBase.demo.model.User;
import CodeBase.demo.repository.FieldRepository;
import CodeBase.demo.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final FieldRepository fieldRepository;

    public ReservationService(ReservationRepository reservationRepository,
                              FieldRepository fieldRepository) {
        this.reservationRepository = reservationRepository;
        this.fieldRepository = fieldRepository;
    }

    //todo: faltan validaciones de disponibildad
    public ReservationResponseDTO createReservation(User user, ReservationDTO dto) {
        Field field = fieldRepository.findById(dto.getFieldId())
                .orElseThrow(() -> new RuntimeException("Cancha no encontrada"));

        Reservation reservation = ReservationMapper.toEntity(dto);
        reservation.setUser(user);
        reservation.setField(field);
        Reservation saved = reservationRepository.save(reservation);

        return ReservationMapper.toDto(saved);
    }

    public List<ReservationResponseDTO> getReservationsByUser(User user) {
        List<Reservation> reservations = reservationRepository.findByUser(user);
        return reservations.stream()
                .map(ReservationMapper::toDto)
                .toList();
    }
}


