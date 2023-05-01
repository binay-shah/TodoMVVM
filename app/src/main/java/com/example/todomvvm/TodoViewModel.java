package com.example.todomvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.todomvvm.database.Todo;

import java.util.List;

public class TodoViewModel extends AndroidViewModel {

    private Repository repository;


    public TodoViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public LiveData<List<Todo>> getAllTodos(){
        return repository.getAllTodos();
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    public void addTodo(Todo todo){
        repository.addTodo(todo);
    }
}
