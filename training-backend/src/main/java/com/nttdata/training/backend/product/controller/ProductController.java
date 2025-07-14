package com.nttdata.training.backend.product.controller;

import com.nttdata.training.backend.product.model.dto.ProductRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product/v1")
@Slf4j
public class ProductController {

    /**
     * POST - Create a new product
     */
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody @Validated(ProductRequestDTO.Add.class) ProductRequestDTO productRequestDTO) {
        log.info("request body {}", productRequestDTO.toString());
        return ResponseEntity.ok("PRODUCT ADDED");
    }

    /**
     * DELETE - Remove a product by ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        log.info("path variable {}", id);
        return ResponseEntity.ok("PRODUCT DELETED");
    }

    /**
     * PUT - Fully update an existing product by ID
     */
    @PutMapping()
    public ResponseEntity<String> updateProduct(@RequestBody @Validated(ProductRequestDTO.Update.class) ProductRequestDTO productRequestDTO) {
        log.info("request body {}", productRequestDTO.toString());
        return ResponseEntity.ok("PRODUCT UPDATED");
    }

    /**
     * PATCH - Partially update an existing product by ID
     */
    @PatchMapping()
    public ResponseEntity<String> partialUpdateProduct(@RequestBody @Validated(ProductRequestDTO.PartialUpdate.class) ProductRequestDTO productRequestDTO) {
        log.info("request body {}", productRequestDTO.toString());
        return ResponseEntity.ok("PRODUCT PARTIAL UPDATED");
    }

    /**
     * GET - Retrieve a product by its ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<String> getProductById(@PathVariable Long id) {
        log.info("path variable {}", id);
        return ResponseEntity.ok("PRODUCT INFO");
    }

    /**
     * GET - Retrieve paginated product data
     */
    @GetMapping("/page")
    public ResponseEntity<String> getPaginatedProductList(@RequestParam Integer page,
                                                          @RequestParam Integer size,
                                                          @RequestParam String sorts) {
        log.info("parameter page {}, size {}, sorts {}", page, size, sorts);
        return ResponseEntity.ok("PRODUCT INFO");
    }
}
