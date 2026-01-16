package CodeBase.demo.repository;

import CodeBase.demo.model.Complex;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplexRepository extends JpaRepository<Complex, Long> {
}
