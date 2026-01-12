package CodeBase.demo.service;

import CodeBase.demo.exception.ProductNotFound;
import CodeBase.demo.model.Product;
import CodeBase.demo.repository.ProductRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFound(id));
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }
}
