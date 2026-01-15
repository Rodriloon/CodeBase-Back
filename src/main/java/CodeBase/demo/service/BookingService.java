package CodeBase.demo.service;

import CodeBase.demo.dto.BookingDTO;
import CodeBase.demo.exception.BookingConflictException;
import CodeBase.demo.mapper.BookingMapper;
import CodeBase.demo.model.Booking;
import CodeBase.demo.model.Field;
import CodeBase.demo.repository.BookingRepository;
import CodeBase.demo.repository.FieldRepository;
import java.util.List;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final FieldRepository fieldRepository;

    public BookingService(BookingRepository bookingRepository, FieldRepository fieldRepository) {
        this.bookingRepository = bookingRepository;
        this.fieldRepository = fieldRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public List<Booking> getBookingsByField(Long fieldId) {
        return bookingRepository.findByFieldId(fieldId);
    }

    public Booking getBooking(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reserva con id " + id + " no encontrada"));
    }

    @Transactional
    public Booking create(BookingDTO bookingDTO) {
        Field field = fieldRepository.findById(bookingDTO.getFieldId())
                .orElseThrow(() -> new EntityNotFoundException("Cancha con id " + bookingDTO.getFieldId() + " no encontrada"));

        // Verificar disponibilidad
        List<Booking> conflictingBookings = bookingRepository.findByFieldIdAndStartTimeBeforeAndEndTimeAfter(
                field.getId(), bookingDTO.getEndTime(), bookingDTO.getStartTime());

        if (!conflictingBookings.isEmpty()) {
            throw new BookingConflictException("La cancha no está disponible en el horario seleccionado");
        }

        Booking booking = BookingMapper.toEntity(bookingDTO, field);
        if (booking.getStatus() == null) {
            booking.setStatus("CONFIRMED");
        }
        
        return bookingRepository.save(booking);
    }
    
    public void cancel(Long id) {
        Booking booking = getBooking(id);
        // Soft delete logic can handle this, or we can just set status to CANCELLED
        booking.setStatus("CANCELLED");
        bookingRepository.save(booking);
    }
}
