package com.example.quizapi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "categories", schema = "public")
public class Category {
    @Id
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category() {
    }

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
