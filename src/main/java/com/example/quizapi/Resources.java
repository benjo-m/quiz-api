package com.example.quizapi;

import java.util.Arrays;
import java.util.List;

public class Resources {
    public static List<String> difficultyList = Arrays.asList("easy", "medium", "hard");
    public static List<String> categoryList = Arrays.asList
        ("technology", "gaming", "astronomy", "sports", "geography", "history", "nature", "movies", "science", "music");

    public static boolean validDifficulty(String difficulty) {
        return difficultyList.contains(difficulty) || difficulty == null;
    }

    public static boolean validCategory(String category) {
        return categoryList.contains(category) || category == null;
    }
}
