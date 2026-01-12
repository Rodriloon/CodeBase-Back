package CodeBase.demo.mapper;

import CodeBase.demo.dto.BookingDTO;
import CodeBase.demo.model.Booking;
import CodeBase.demo.model.Resource;

public class BookingMapper {

    private BookingMapper() {}

    public static Booking toEntity(BookingDTO dto, Resource resource) {
        return Booking.builder()
                .startTime(dto.getStartTime())
                .endTime(dto.getEndTime())
                .customerName(dto.getCustomerName())
                .status(dto.getStatus())
                .resource(resource)
                .build();
    }

    public static BookingDTO toDto(Booking entity) {
        return BookingDTO.builder()
                .id(entity.getId())
                .startTime(entity.getStartTime())
                .endTime(entity.getEndTime())
                .resourceId(entity.getResource() != null ? entity.getResource().getId() : null)
                .customerName(entity.getCustomerName())
                .status(entity.getStatus())
                .build();
    }
}
