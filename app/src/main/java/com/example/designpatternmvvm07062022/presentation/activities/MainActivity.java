package com.example.designpatternmvvm07062022.presentation.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.designpatternmvvm07062022.R;
import com.example.designpatternmvvm07062022.data.model.Todo;
import com.example.designpatternmvvm07062022.presentation.adapters.TodoAdapter;
import com.example.designpatternmvvm07062022.presentation.viewmodels.MainViewModel;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcvTodo;
    TodoAdapter todoAdapter;
    MainViewModel mainViewModel;
    Button btnInsertRandom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvTodo = findViewById(R.id.recyclerview_todo);
        btnInsertRandom = findViewById(R.id.button_insert);

        mainViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new MainViewModel();
            }
        }).get(MainViewModel.class);

        todoAdapter = new TodoAdapter();
        rcvTodo.setAdapter(todoAdapter);
        rcvTodo.setHasFixedSize(true);

        mainViewModel.getTodoLiveData().observe(this, new Observer<List<Todo>>() {
            @Override
            public void onChanged(List<Todo> todos) {
                todoAdapter.setTodoList(todos);
            }
        });

        btnInsertRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int valueRandom = new Random().nextInt(100);
                mainViewModel.insertTodo(new Todo("Random Title " + valueRandom, "Random Do something " + valueRandom));
            }
        });

        todoAdapter.setOnItemClickListener(new TodoAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                mainViewModel.removeTodo(position);
            }
        });
    }
}
