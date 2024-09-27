package com.testeangular.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    // Class model of Product
    @Id
    private long id;

    private String name;
    private double price;
    private long class_id;
}
