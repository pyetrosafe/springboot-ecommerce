package com.pyetrosafe.e_commerce.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pyetrosafe.e_commerce.dtos.ProductRecordDto;
import com.pyetrosafe.e_commerce.models.ProductModel;
import com.pyetrosafe.e_commerce.repositories.ProductRepository;

import jakarta.validation.Valid;


@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/products")
    public ResponseEntity<ProductModel> save(@RequestBody @Valid ProductRecordDto productRecordDto) {
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> update(@PathVariable(value="id") UUID id, @RequestBody @Valid ProductRecordDto productRecordDto) {

        Optional<ProductModel> productOpt = productRepository.findById(id);

        if (productOpt.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");

        var productModel = productOpt.get();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value="id") UUID id) {

        Optional<ProductModel> productOpt = productRepository.findById(id);

        if (productOpt.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");

        productRepository.delete(productOpt.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> get(@PathVariable(value="id") UUID id) {

        System.out.println("PASSOU GET ONE");
        Optional<ProductModel> productOpt = productRepository.findById(id);

        if (productOpt.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");

        return ResponseEntity.status(HttpStatus.OK).body(productOpt.get());
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> get() {
        System.out.println("PASSOU GET ALL");

        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }

}
