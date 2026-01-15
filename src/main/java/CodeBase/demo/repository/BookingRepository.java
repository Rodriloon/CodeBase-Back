package CodeBase.demo.repository;

import CodeBase.demo.model.Booking;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    
    List<Booking> findByFieldId(Long fieldId);

    // Validar superposición de reservas
    // SELECT * FROM bookings WHERE field_id = ? AND start_time < ? AND end_time > ?
    List<Booking> findByFieldIdAndStartTimeBeforeAndEndTimeAfter(
        Long fieldId, LocalDateTime endTime, LocalDateTime startTime
    );
}
