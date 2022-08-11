package com.example.designpatternmvvm07062022.presentation.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.designpatternmvvm07062022.R;
import com.example.designpatternmvvm07062022.presentation.adapters.TodoAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcvTodo;
    TodoAdapter todoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvTodo = findViewById(R.id.recyclerview_todo);
        todoAdapter = new TodoAdapter();
    }
}
