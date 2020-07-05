package edu.ntub.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product", schema = "demo")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private Integer price;
}
