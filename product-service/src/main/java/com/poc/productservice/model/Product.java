package com.poc.productservice.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


/**
 * Product entity map to product table
 */
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

  @Id
  @SequenceGenerator(name = "product_seq_gen", sequenceName = "product_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_gen")
  @Column(name = "PRODUCT_ID")
  private long productId;

  @Column(name = "PRODUCT_NAME")
  private String productName;

  @Column(name = "PRODUCT_DESC")
  private String description;

  @Column(name = "STATUS")
  private boolean status;
}
