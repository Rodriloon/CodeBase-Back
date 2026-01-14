package CodeBase.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE bookings SET deleted = true WHERE id=?")
@SQLRestriction("deleted = false")
public class Booking extends BaseEntity {
    
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    
    @ManyToOne
    private Field field;
    
    private String customerName;
    private String status; // e.g., "CONFIRMED", "CANCELLED"
}
