package me.vasujain.microservices.product_service.controller;

import lombok.RequiredArgsConstructor;
import me.vasujain.microservices.product_service.dto.ProductRequest;
import me.vasujain.microservices.product_service.model.Product;
import me.vasujain.microservices.product_service.repository.ProductRepository;
import me.vasujain.microservices.product_service.response.ApiResponse;
import me.vasujain.microservices.product_service.response.ResponseUtil;
import me.vasujain.microservices.product_service.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ApiResponse<Product>> createProduct(@RequestBody ProductRequest productRequest){
        Product product = productService.createProduct(productRequest);
        return ResponseUtil.created(product, "Product created successfully");
    }

    @GetMapping
    public ResponseEntity<ApiResponse<?>> getAllProducts(@RequestParam(defaultValue = "false") boolean paginated,
                                                         @RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "10") int size){

        Object products = productService.getAllProducts(paginated, PageRequest.of(page, size));

        if (products instanceof List) {
            return ResponseUtil.ok((List<Product>) products);
        } else if (products instanceof Page) {
            return ResponseUtil.okPage((Page<Product>) products);
        } else {
            throw new IllegalStateException("Unexpected return type from productService.getAllProducts");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> getProductById(@PathVariable String id){
        Product product = productService.getProductById(id);
        return ResponseUtil.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> updateProduct(@PathVariable String id, @RequestBody ProductRequest productRequest){
        Product product = productService.updateProduct(id, productRequest);
        return ResponseUtil.ok(product, "Product updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteProduct(@PathVariable String id){
        productService.deleteProduct(id);
        return ResponseUtil.ok(null, "Product deleted successfully");
    }
}
