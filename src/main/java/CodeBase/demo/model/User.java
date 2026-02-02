package CodeBase.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Complex> complexes = new ArrayList<>();

    private String name;
    @Column(unique = true)
    private String email;
    private String image_url;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        ADMIN,
        USER
    }

    public boolean isAdmin() {
        return Role.ADMIN.equals(this.role);
    }
}
