package com.example.designpatternmvvm07062022.presentation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.designpatternmvvm07062022.R;
import com.example.designpatternmvvm07062022.data.model.Todo;

import java.util.List;

/**
 * Created by pphat on 8/11/2022.
 */
public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder>{

    List<Todo> todoList;

    public TodoAdapter(List<Todo> todoList) {
        this.todoList = todoList;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_item_todo, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        holder.bind(todoList.get(position));
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    class TodoViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDescription;

        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.text_view_title);
            tvDescription = itemView.findViewById(R.id.text_view_description);
        }

        public void bind(Todo todo) {
            tvTitle.setText(todo.getTitle());
            tvDescription.setText(todo.getDescription());
        }
    }
}
