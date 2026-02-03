package CodeBase.demo.repository;

import CodeBase.demo.model.Reservation;
import CodeBase.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUser(User user);
}
