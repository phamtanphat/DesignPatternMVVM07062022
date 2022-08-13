package com.example.designpatternmvvm07062022.data.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pphat on 8/11/2022.
 */
public class Todo {
    private String title;
    private String description;

    public Todo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
