package com.example.quizapi.response;

import java.util.List;

public class CategoryResponse {
    private List<String> categoryList;

    public CategoryResponse() {
    }

    public CategoryResponse(List<String> categoryList) {
        this.categoryList = categoryList;
    }

    public List<String> getCategoryList() {
        return categoryList;
    }
}
