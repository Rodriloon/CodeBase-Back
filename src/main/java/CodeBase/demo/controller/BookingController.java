package CodeBase.demo.controller;

import CodeBase.demo.dto.BookingDTO;
import CodeBase.demo.mapper.BookingMapper;
import CodeBase.demo.model.Booking;
import CodeBase.demo.service.BookingService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {
    
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        List<BookingDTO> bookings = bookingService.getAllBookings().stream()
                .map(BookingMapper::toDto)
                .toList();
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> getBooking(@PathVariable Long id) {
        BookingDTO booking = BookingMapper.toDto(bookingService.getBooking(id));
        return ResponseEntity.ok(booking);
    }

    @PostMapping
    public ResponseEntity<BookingDTO> create(@Valid @RequestBody BookingDTO dto) {
        Booking saved = bookingService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(BookingMapper.toDto(saved));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancel(@PathVariable Long id) {
        bookingService.cancel(id); // Logically cancel or delete
        return ResponseEntity.noContent().build();
    }
}
