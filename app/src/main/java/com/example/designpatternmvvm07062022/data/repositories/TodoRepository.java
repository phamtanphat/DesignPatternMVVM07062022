package com.example.designpatternmvvm07062022.data.repositories;

import com.example.designpatternmvvm07062022.data.model.Todo;

import java.util.List;

/**
 * Created by pphat on 8/11/2022.
 */
public class TodoRepository {
    private List<Todo> todos;

    public TodoRepository(List<Todo> todos) {
        this.todos = todos;
    }

    public void insertTodo(Todo todo) {
        todos.add(todo);
    }

    public void removeTodo(Todo todo) {
        todos.remove(todo);
    }

    public void updateTodo(int index, Todo todo) {
        todos.set(index, todo);
    }
}
