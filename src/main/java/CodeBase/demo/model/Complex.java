package CodeBase.demo.model;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "complexes")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE complexes SET deleted = true WHERE id=?")
@SQLRestriction("deleted = false")
public class Complex extends BaseEntity {

    @OneToMany(mappedBy = "complex", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Field> fields = new ArrayList<>();

    @Column(nullable = false)
    private String name;

    private String location;
}
