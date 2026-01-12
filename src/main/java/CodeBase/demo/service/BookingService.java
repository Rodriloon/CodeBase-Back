package CodeBase.demo.service;

import CodeBase.demo.dto.BookingDTO;
import CodeBase.demo.exception.BookingConflictException;
import CodeBase.demo.exception.ResourceNotFound;
import CodeBase.demo.mapper.BookingMapper;
import CodeBase.demo.model.Booking;
import CodeBase.demo.model.Resource;
import CodeBase.demo.repository.BookingRepository;
import CodeBase.demo.repository.ResourceRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ResourceRepository resourceRepository;

    public BookingService(BookingRepository bookingRepository, ResourceRepository resourceRepository) {
        this.bookingRepository = bookingRepository;
        this.resourceRepository = resourceRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBooking(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Reserva con id " + id + " no encontrada"));
    }

    @Transactional
    public Booking create(BookingDTO bookingDTO) {
        Resource resource = resourceRepository.findById(bookingDTO.getResourceId())
                .orElseThrow(() -> new ResourceNotFound(bookingDTO.getResourceId()));

        // Verificar disponibilidad
        // Si hay alguna reserva que empiece antes de que termine esta Y termine después de que empiece esta
        List<Booking> conflictingBookings = bookingRepository.findByResourceIdAndStartTimeBeforeAndEndTimeAfter(
                resource.getId(), bookingDTO.getEndTime(), bookingDTO.getStartTime());

        if (!conflictingBookings.isEmpty()) {
            throw new BookingConflictException("El recurso no está disponible en el horario seleccionado");
        }

        Booking booking = BookingMapper.toEntity(bookingDTO, resource);
        // Default status if null
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
