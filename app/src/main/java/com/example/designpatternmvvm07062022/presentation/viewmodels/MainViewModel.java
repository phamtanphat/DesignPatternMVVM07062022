package com.example.designpatternmvvm07062022.presentation.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.designpatternmvvm07062022.data.model.Todo;
import com.example.designpatternmvvm07062022.data.repositories.TodoRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pphat on 8/11/2022.
 */
public class MainViewModel extends ViewModel {
    private MutableLiveData<List<Todo>> todoLiveData = new MutableLiveData<>();
    private TodoRepository todoRepository;

    public MainViewModel() {
        todoLiveData.setValue(new ArrayList<>());
        todoRepository = new TodoRepository(todoLiveData.getValue());
    }

    public LiveData<List<Todo>> getTodoLiveData() {
        return todoLiveData;
    }

    public void insertTodo(Todo todo) {
        todoLiveData.setValue(todoRepository.insertTodo(todo));
    }

    public void removeTodo(int position) {
        todoLiveData.setValue(todoRepository.removeTodo(position));
    }

}
