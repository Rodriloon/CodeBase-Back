package CodeBase.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "fields")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE fields SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Field extends BaseEntity {
    
    private String name; // e.g., "Cancha 1", "El Estadio"
    private String description;
    
    // Atributos específicos de Fútbol
    private Integer capacity; // 5, 7, 9, 11
    
    @Enumerated(EnumType.STRING)
    private SurfaceType surface; // SINTETICO, ALFOMBRA, CESPED
    
    private boolean isIndoor; // Techada
    
    private String status; // AVAILABLE, MAINTENANCE
    
    public enum SurfaceType {
        SYNTHETIC_GRASS,
        NATURAL_GRASS,
        PARQUET,
        CONCRETE,
        CARPET
    }
}
