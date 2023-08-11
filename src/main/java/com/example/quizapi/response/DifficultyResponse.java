package com.example.quizapi.response;

import java.util.List;

public class DifficultyResponse {
    private List<String> difficultyList;

    public DifficultyResponse(List<String> difficulties) {
        this.difficultyList = difficulties;
    }

    public List<String> getDifficultyList() {
        return difficultyList;
    }
}
