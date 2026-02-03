package CodeBase.demo.mapper;

import CodeBase.demo.dto.reservation.ReservationDTO;
import CodeBase.demo.dto.reservation.ReservationResponseDTO;
import CodeBase.demo.model.Reservation;

public class ReservationMapper {
    public static Reservation toEntity(ReservationDTO dto) {
        return Reservation.builder()
                .startAt(dto.getStartAt())
                .build();
    }

    public static ReservationResponseDTO toDto(Reservation entity) {
        return ReservationResponseDTO.builder()
                .id(entity.getId())
                .startAt(entity.getStartAt())
                .field(FieldMapper.toDtoWithComplex(entity.getField()))
                .build();
    }
}
