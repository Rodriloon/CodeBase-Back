package CodeBase.demo.mapper;

import CodeBase.demo.dto.ProductDTO;
import CodeBase.demo.model.Product;

public class ProductMapper {

    private ProductMapper() {}

    public static Product toEntity(ProductDTO dto) {
        return Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .image(dto.getImage())
                .build();
    }

    public static ProductDTO toDto(Product product) {
        return ProductDTO.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .image(product.getImage())
                .build();
    }
}
