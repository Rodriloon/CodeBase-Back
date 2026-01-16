package CodeBase.demo.repository;

import CodeBase.demo.model.Complex;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplexRepository extends JpaRepository<Complex, Long> {
    List<Complex> findByUserId(Long userId);
}
