package CodeBase.demo.repository;

import CodeBase.demo.model.Field;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FieldRepository extends JpaRepository<Field, Long> {
}
