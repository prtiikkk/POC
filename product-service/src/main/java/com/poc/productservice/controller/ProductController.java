package com.poc.productservice.controller;

import com.poc.productservice.model.ProductDTO;
import com.poc.productservice.service.PaymentService;
import com.poc.productservice.service.ProductService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Product controller.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

  private static final Logger log = LoggerFactory.getLogger(ProductController.class);

  @Autowired
  private ProductService productService;
  @Autowired
  private PaymentService paymentService;

  /**
   * Add product response entity.
   *
   * @param productDTO the product dto
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<ProductDTO> addProduct(@RequestBody @NonNull final ProductDTO productDTO) {
    log.info("Inside Product controller:: add new product");
    return new ResponseEntity<ProductDTO>(productService.addProduct(productDTO),
        HttpStatus.CREATED);
  }

  /**
   * Delete product
   *
   * @param productId productId
   */
  @DeleteMapping(value = "/{productId}")
  public ResponseEntity<String> deleteEmployee(@PathVariable long productId) {
    log.info("Inside Product controller:: delete product");
    productService.deleteEmployee(productId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * Gets all products.
   *
   * @param page the page
   * @param size the size
   * @return the all products
   */
  @GetMapping
  public ResponseEntity<List<ProductDTO>> getAllProducts(@RequestParam int page,
      @RequestParam int size) {
    return new ResponseEntity<>(productService.getProducts(PageRequest.of(page, size)),
        HttpStatus.OK);
  }

  /**
   * Gets product by id.
   *
   * @param id the id
   * @return the product by id
   */
  @GetMapping(value = "/{id}")
  public ResponseEntity<ProductDTO> getProductById(@PathVariable long id) {
    return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
  }

  @PostMapping("/purchase")
  public ResponseEntity<String> purchaseProduct() {
    return ResponseEntity.ok("Payment Id: " + paymentService.sendPaymentId());
  }
}