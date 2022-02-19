package com.sda.javaspring.controller.rest;

import com.sda.javaspring.entity.ProductEntity;
import com.sda.javaspring.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api_products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public List<ProductEntity> getProductEntities() {
        log.info("Find all products");
        return productService.readProductEntities();
    }

    @GetMapping("/product/{id}")
    public ProductEntity getProductById(@PathVariable("id") Long id) {
        log.info("Find product by ID");
        return productService.readProductById(id);
    }

    @GetMapping("/product/{id}/price_vat")
    public double getProductPriceWithVAT(@PathVariable("id") Long id) {
        log.info("Find price of the product with VAT");
        return ProductService.getPriceWithVAT(productService.readProductById(id));
    }

}
