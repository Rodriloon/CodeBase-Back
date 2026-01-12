package CodeBase.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "resources")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE resources SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Resource extends BaseEntity {
    
    private String name; // e.g., "Cancha 5", "Peluquero Juan"
    private String description;
    private String type; // e.g., "FIELD", "BARBER", "TABLE"
    private String status; // e.g., "AVAILABLE", "MAINTENANCE"
}
