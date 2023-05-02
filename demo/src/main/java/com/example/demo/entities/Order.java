//package com.example.demo.entities;
//
//import com.example.demo.entities.user.User;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static jakarta.persistence.GenerationType.SEQUENCE;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Builder
//@Entity(name = "Order")
//@Table(name = "orders")
//public class Order {
//    @Id
//    @SequenceGenerator(
//            name = "order_sequence",
//            sequenceName = "order_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = SEQUENCE,
//            generator = "order_sequence"
//    )
//    @Column(
//            name = "id"
//    )
//    private Long id;
//    @Column(
//            name = "description"
//    )
//    private LocalDateTime time;
//
//    @OneToMany
//    @JoinColumn(name = "product_id")
//    private List<Product> orderedProducts;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    private String address;
//}
