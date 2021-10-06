package br.dev.correa.springbootproductscrud.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }

    public Product editProduct(Product product) {
        Product original = productRepository.findById(product.getId()).orElseThrow(
                () -> new IllegalStateException("Product does not exist")
        );
        if (
                product.getName() != null
                && product.getName().length() > 0
                && !Objects.equals(original.getName(), product.getName())
        ) {
            original.setName(product.getName());
        }

        if (
                product.getPrice() != null
                && product.getPrice() > 0
                && !Objects.equals(original.getPrice(), product.getPrice())
        ) {
            original.setPrice(product.getPrice());
        }
        return productRepository.save(original);
    }
}
