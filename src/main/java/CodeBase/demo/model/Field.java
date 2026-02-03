package CodeBase.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fields")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE fields SET deleted = true WHERE id=?")
@SQLRestriction("deleted = false")
public class Field extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "complex_id", nullable = false)
    private Complex complex;

    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();

    private String name;
    private String description;
    private Integer capacity; // 5, 7, 9, 11
    private boolean isIndoor;
    @Enumerated(EnumType.STRING)
    private FieldStatus status;

    public enum FieldStatus {
        AVAILABLE,
        MAINTENANCE
    }

    @Enumerated(EnumType.STRING)
    private SurfaceType surface;

    public enum SurfaceType {
        SYNTHETIC_GRASS,
        NATURAL_GRASS,
        PARQUET,
        CONCRETE,
        CARPET
    }
}
