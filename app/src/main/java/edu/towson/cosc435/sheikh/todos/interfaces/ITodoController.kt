package edu.towson.cosc435.sheikh.todos.interfaces

import edu.towson.cosc435.sheikh.todos.model.Todo

interface ITodoController {
    fun deleteTodo(idx: Int)
    fun editTodo(idx: Int)
    fun markCompleted(idx: Int)


    // Recycler View functions
    fun getTodo(idx: Int): Todo
    fun getTodos(): List<Todo>


}