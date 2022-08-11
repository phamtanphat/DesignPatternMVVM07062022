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

    public static List<Todo> getMock() {
        return new ArrayList<>(Arrays.asList(
                new Todo("Title todo 1", "Do something 1"),
                new Todo("Title todo 2", "Do something 2"),
                new Todo("Title todo 3", "Do something 3"),
                new Todo("Title todo 4", "Do something 4"),
                new Todo("Title todo 5", "Do something 5")
        ));
    }
}
