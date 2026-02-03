package CodeBase.demo.dto.complex;

import CodeBase.demo.dto.field.FieldResponseDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComplexResponseDTO {
    private Long id;
    private String name;
    private String location;
    private List<FieldResponseDTO> fields;
}
