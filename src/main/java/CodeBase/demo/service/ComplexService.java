package CodeBase.demo.service;

import CodeBase.demo.dto.complex.ComplexDTO;
import CodeBase.demo.dto.complex.ComplexResponseDTO;
import CodeBase.demo.exception.complex.ComplexNotFound;
import CodeBase.demo.exception.user.ForbiddenOperation;
import CodeBase.demo.mapper.ComplexMapper;
import CodeBase.demo.model.Complex;
import CodeBase.demo.model.User;
import CodeBase.demo.repository.ComplexRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComplexService {

    private final ComplexRepository complexRepository;

    public ComplexService(ComplexRepository complexRepository) {
        this.complexRepository = complexRepository;
    }

    public List<ComplexResponseDTO> getComplexesByAdmin(User user) {
        if (!user.isAdmin()) throw new ForbiddenOperation("No tenés permisos de admin para obtener todos los complejos");

        return complexRepository.findByUserId(user.getId())
                .stream()
                .map(ComplexMapper::toDto)
                .toList();
    }

    public ComplexResponseDTO getComplex(Long id) {
        Complex complex = complexRepository.findByIdWithFields(id)
                .orElseThrow(() -> new ComplexNotFound(id));
        return ComplexMapper.toDtoWithFields(complex);
    }

    public ComplexResponseDTO create(User user, ComplexDTO complexDto) {
        if (!user.isAdmin()) throw new ForbiddenOperation("No tenés permisos de admin para crear un complejo");

        Complex complex = ComplexMapper.toEntity(complexDto);
        complex.setUser(user);
        Complex saved = complexRepository.save(complex);

        return ComplexMapper.toDto(saved);
    }

    public ComplexResponseDTO update(Long id, ComplexDTO complexDto) {
        Complex complexDetails = ComplexMapper.toEntity(complexDto);
        Complex complex = complexRepository.findById(id)
                .orElseThrow(() -> new ComplexNotFound(id));

        complex.setName(complexDetails.getName());
        complex.setLocation(complexDetails.getLocation());

        Complex updated = complexRepository.save(complex);
        return ComplexMapper.toDto(updated);
    }

    public void delete(Long id) {
        Complex complex = complexRepository.findById(id)
                .orElseThrow(() -> new ComplexNotFound(id));
        complexRepository.delete(complex);
    }
}
