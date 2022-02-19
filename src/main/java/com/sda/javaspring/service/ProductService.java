package com.sda.javaspring.service;

import com.sda.javaspring.entity.ProductEntity;
import com.sda.javaspring.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductEntity> readProductEntities() {
        log.info("Reading all products...");
        List<ProductEntity> entities = productRepository.findAll();
        log.info("Products read successfully!");
        return entities;
    }

    public ProductEntity readProductById(Long id) {
        log.info("Reading product with ID [{}]", id);
        Optional<ProductEntity> product = productRepository.findById(id);

        if (product.isPresent())
        {
            log.info("Found the requested product: {}", product.get());
            return product.get();
        }

        return null;
    }

    public static double getPriceWithVAT(ProductEntity product)
    {
        return product.getPrice() * 1.23;
    }

}
