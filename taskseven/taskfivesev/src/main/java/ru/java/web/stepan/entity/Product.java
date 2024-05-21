package ru.java.web.stepan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author SDudin
 */
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "balance")
    private String balance;
    @Column(name = "product_type")
    private String productType;
    @Column(name = "user_id")
    private Long userId;
}