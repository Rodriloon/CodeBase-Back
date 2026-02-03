package CodeBase.demo.repository;

import CodeBase.demo.model.Complex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ComplexRepository extends JpaRepository<Complex, Long> {
    List<Complex> findByUserId(Long userId);

    @Query("SELECT c FROM Complex c LEFT JOIN FETCH c.fields WHERE c.id = :id")
    Optional<Complex> findByIdWithFields(@Param("id") Long id);
}
