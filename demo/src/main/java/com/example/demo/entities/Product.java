//package com.example.demo.entities;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import static jakarta.persistence.GenerationType.SEQUENCE;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Builder
//@Entity(name = "Product")
//@Table(name = "products")
//public class Product {
//    @Id
//    @SequenceGenerator(
//            name = "product_sequence",
//            sequenceName = "product_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = SEQUENCE,
//            generator = "product_sequence"
//    )
//    @Column(
//            name = "id"
//    )
//    private Long id;
//    @Column(
//            name = "name"
//    )
//    private String name;
//    @Column(
//            name = "description"
//    )
//    private String description;
//
//
//}
