package CodeBase.demo.mapper;

import CodeBase.demo.dto.BookingDTO;
import CodeBase.demo.model.Booking;
import CodeBase.demo.model.Field;

public class BookingMapper {

    private BookingMapper() {}

    public static Booking toEntity(BookingDTO dto, Field field) {
        return Booking.builder()
                .startTime(dto.getStartTime())
                .endTime(dto.getEndTime())
                .customerName(dto.getCustomerName())
                .status(dto.getStatus())
                .field(field)
                .build();
    }

    public static BookingDTO toDto(Booking entity) {
        return BookingDTO.builder()
                .id(entity.getId())
                .startTime(entity.getStartTime())
                .endTime(entity.getEndTime())
                .fieldId(entity.getField() != null ? entity.getField().getId() : null)
                .customerName(entity.getCustomerName())
                .status(entity.getStatus())
                .build();
    }
}
