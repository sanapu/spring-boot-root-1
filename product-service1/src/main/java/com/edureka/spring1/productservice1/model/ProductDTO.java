package com.edureka.spring1.productservice1.model;


import lombok.*;

import javax.persistence.*;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProductDTO {

    Long id;

    String name;

    String description;

    String source;

    String userInfo;
}
