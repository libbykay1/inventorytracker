package com.example.inventorytracker.product;



import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table
public class Product implements Serializable {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;
    private String name;
    private String category;
    private String unit;
    private String count;
    @Transient
    private LocalDate lastCounted;




    public Product() {}

    public Product(Long id, String name, String category, String unit, String count) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.unit = unit;
        this.count = count;
    }

    public Product(String name, String category, String unit, String count) {
        this.name = name;
        this.category = category;
        this.unit = unit;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public LocalDate getLastCounted() {
        return LocalDate.now();
    }

    public void setLastCounted() {
        this.lastCounted = LocalDate.now();
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" +category + '\'' +
                ", unit='" + unit + '\'' +
                ", count='" + count + '\'' +
                ", lastCount='" + lastCounted + '\'' +
                '}';
    }
}
