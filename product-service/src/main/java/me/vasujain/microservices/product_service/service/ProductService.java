package me.vasujain.microservices.product_service.service;

import lombok.RequiredArgsConstructor;
import me.vasujain.microservices.product_service.dto.ProductRequest;
import me.vasujain.microservices.product_service.exception.ResourceNotFoundException;
import me.vasujain.microservices.product_service.model.Product;
import me.vasujain.microservices.product_service.repository.ProductRepository;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Object getAllProducts(boolean paginated, PageRequest pageRequest) {
        if (paginated){
            return productRepository.findAll(pageRequest);
        } else {
            return productRepository.findAll();
        }
    }

    public Product getProductById(String id) {
        return productRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Product not found with id: " + id));
    }

    public Product createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .id(productRequest.id())
                .name(productRequest.name())
                .price(productRequest.price())
                .description(productRequest.description())
                .build();

        return productRepository.save(product);
    }

    public Product updateProduct(String id, ProductRequest productRequest) {
        Product product = getProductById(id);

        if (productRequest.name() != null) product.setName(productRequest.name());
        if (productRequest.price() != null) product.setPrice(productRequest.price());
        if (productRequest.description() != null) product.setDescription(productRequest.description());

        return productRepository.save(product);
    }

    public void deleteProduct(String id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}
