package CodeBase.demo.repository;

import CodeBase.demo.model.Booking;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    
    // Validar superposición de reservas
    // SELECT * FROM bookings WHERE resource_id = ? AND start_time < ? AND end_time > ?
    List<Booking> findByResourceIdAndStartTimeBeforeAndEndTimeAfter(
        Long resourceId, LocalDateTime endTime, LocalDateTime startTime
    );
}
