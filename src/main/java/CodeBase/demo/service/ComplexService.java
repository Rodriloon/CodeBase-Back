package CodeBase.demo.service;

import CodeBase.demo.exception.ComplexNotFound;
import CodeBase.demo.model.Complex;
import CodeBase.demo.repository.ComplexRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplexService {

    private final ComplexRepository complexRepository;

    public ComplexService(ComplexRepository complexRepository) {
        this.complexRepository = complexRepository;
    }

    public List<Complex> getAllComplexes() {
        return complexRepository.findAll();
    }

    public Complex getComplex(Long id) {
        return complexRepository.findById(id).orElseThrow(() -> new ComplexNotFound(id));
    }

    public Complex create(Complex complex) {
        return complexRepository.save(complex);
    }

    public Complex update(Long id, Complex complexDetails) {
        Complex complex = getComplex(id);
        complex.setName(complexDetails.getName());
        complex.setLocation(complexDetails.getLocation());
        return complexRepository.save(complex);
    }

    public void delete(Long id) {
        Complex complex = getComplex(id);
        complexRepository.delete(complex);
    }
}