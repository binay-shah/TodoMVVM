package com.example.todomvvm;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.todomvvm.database.Todo;
import com.example.todomvvm.database.TodoDatabase;

import java.util.List;

public class Repository {

    private TodoDatabase database;
    private LiveData<List<Todo>> todoList;

    public Repository(Application application) {
        database = TodoDatabase.getDatabase(application);
        todoList = database.todoDao().getAllTodos();
    }

    public LiveData<List<Todo>> getAllTodos(){
        return todoList;
    }

    public void deleteAll(){
        database.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                database.todoDao().deleteAll();
            }
        });
    }

    public void addTodo(Todo todo){
        database.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                database.todoDao().addTodo(todo);
            }
        });
    }
}
