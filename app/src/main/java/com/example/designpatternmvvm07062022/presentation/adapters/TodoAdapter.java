package com.example.designpatternmvvm07062022.presentation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    private OnItemClickListener onItemClickListener;

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
        notifyDataSetChanged();
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
        return todoList != null && todoList.size() > 0 ? todoList.size() : 0;
    }

    class TodoViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDescription;
        Button btnRemove;
        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.text_view_title);
            tvDescription = itemView.findViewById(R.id.text_view_description);
            btnRemove = itemView.findViewById(R.id.button_remove);

            btnRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onClick(getAdapterPosition());
                    }
                }
            });
        }

        public void bind(Todo todo) {
            tvTitle.setText(todo.getTitle());
            tvDescription.setText(todo.getDescription());
        }
    }

    public void setOnItemClickListener(OnItemClickListener onClickListener) {
        onItemClickListener = onClickListener;
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }
}
