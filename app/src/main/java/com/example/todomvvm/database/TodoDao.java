package com.example.todomvvm.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.todomvvm.database.Todo;

import java.util.List;

@Dao
public interface TodoDao {

    @Query("select * from todos")
    LiveData<List<Todo>> getAllTodos();

    @Insert
    void addTodo(Todo todo);

    @Query("delete from todos where id=:id")
    void deleteTodoByID(int id);

    @Query("delete from todos")
    void deleteAll();
}
