package com.poc.productservice.repository;

import com.poc.productservice.model.Product;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  List<Product> findAllByStatus(boolean status, Pageable pageable);

}
