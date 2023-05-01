package com.example.todomvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.todomvvm.database.Todo;
import com.example.todomvvm.database.TodoAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TodoAdapter todoAdapter;
    private TodoViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.todoList);
        todoAdapter = new TodoAdapter();
        recyclerView.setAdapter(todoAdapter);

        viewModel = new ViewModelProvider(this).get(TodoViewModel.class);

        viewModel.getAllTodos().observe(this, new Observer<List<Todo>>() {
            @Override
            public void onChanged(List<Todo> todos) {
                if(todos != null) {
                    todoAdapter.submitTodos(todos);

                }
            }
        });

    }
}