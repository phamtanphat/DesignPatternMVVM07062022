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

    public List<Todo> insertTodo(Todo todo) {
        todos.add(todo);
        return todos;
    }

    public List<Todo> removeTodo(int position) {
        todos.remove(position);
        return todos;
    }

    public List<Todo> updateTodo(int index, Todo todo) {
        todos.set(index, todo);
        return todos;
    }
}
