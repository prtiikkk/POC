package com.poc.productservice.service;


import com.poc.productservice.constant.ErrorConstant;
import com.poc.productservice.exception.BusinessException;
import com.poc.productservice.model.Product;
import com.poc.productservice.model.ProductDTO;
import com.poc.productservice.repository.ProductRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private static final Logger log = LoggerFactory.getLogger(ProductService.class);
  @Autowired
  private ModelMapper modelMapper;
  @Autowired
  private ProductRepository productRepository;


  @Transactional
  public ProductDTO addProduct(@NonNull ProductDTO productDTO) {
    Product product = this.modelMapper.map(productDTO, Product.class);
    Product savedProduct = this.productRepository.save(product);
    log.info("Inside Product Service:: product added successfully ");
    return this.modelMapper.map(savedProduct, ProductDTO.class);
  }

  @Transactional
  public void deleteEmployee(long productId) {
    Product product = productRepository.findById(productId)
        .orElseThrow(() -> new RuntimeException("Employee not found with Id"));
    product.setStatus(false);
    log.info("Inside Product Service:: product deleted successfully with productId {}", productId);
  }

  /**
   * Get Employee list
   *
   * @param pageable pageable
   * @return List<ProductDTO>
   */
  @Transactional
  public List<ProductDTO> getProducts(Pageable pageable) {
    log.info("Inside Product Service:: get products ");
    return productRepository.findAllByStatus(true, pageable).stream()
        .map(product -> this.modelMapper.map(product, ProductDTO.class))
        .collect(Collectors.toList());
  }


  /**
   * Get product by id
   *
   * @param productId productId
   * @return ProductDTO
   */
  @Transactional
  public ProductDTO getProductById(long productId) {
    Product product = productRepository.findById(productId)
        .orElseThrow(() -> new BusinessException(ErrorConstant.PRODUCT_NOT_FOUND));
    return this.modelMapper.map(product, ProductDTO.class);
  }


}
