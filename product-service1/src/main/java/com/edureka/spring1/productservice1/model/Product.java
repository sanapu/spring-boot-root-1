package com.edureka.spring1.productservice1.model;


import lombok.*;

import javax.persistence.*;

@Data
@ToString
@EqualsAndHashCode(exclude = "id")
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "product" ,catalog = "spring")
public class Product {
    @Id
    @GeneratedValue
    @Column(name="id")
    Long id;
    @Column(name="name")
    String name;
    @Column(name="description")
    String description;
}
