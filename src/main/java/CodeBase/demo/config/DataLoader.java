package CodeBase.demo.config;

import CodeBase.demo.model.Field;
import CodeBase.demo.repository.FieldRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final FieldRepository fieldRepository;

    public DataLoader(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (fieldRepository.count() == 0) {
            fieldRepository.save(Field.builder()
                    .name("Cancha 1 (Sintético)")
                    .capacity(5)
                    .surface(Field.SurfaceType.SYNTHETIC_GRASS)
                    .isIndoor(true)
                    .status("AVAILABLE")
                    .build());

            fieldRepository.save(Field.builder()
                    .name("Estadio Principal")
                    .capacity(11)
                    .surface(Field.SurfaceType.NATURAL_GRASS)
                    .isIndoor(false)
                    .status("AVAILABLE")
                    .build());
            
            fieldRepository.save(Field.builder()
                    .name("Cancha 2 (Parquet)")
                    .capacity(5)
                    .surface(Field.SurfaceType.PARQUET)
                    .isIndoor(true)
                    .description("Ideal para días de lluvia")
                    .status("AVAILABLE")
                    .build());
            
            System.out.println("--- DATOS DE PRUEBA CARGADOS ---");
        } else {
            System.out.println("--- BASE DE DATOS YA TIENE DATOS ('" + fieldRepository.count() + "' canchas), OMITIENDO CARGA DE PRUEBA ---");
        }
    }
}
