package edu.towson.cosc435.sheikh.todos.interfaces
import edu.towson.cosc435.sheikh.todos.model.Todo


interface ITodoRepository {
    fun getCount(): Int
    fun getTodo(idx: Int): Todo
    fun getTodos(): List<Todo>
    fun deleteTodo(idx: Int)
    fun addTodo(todo: Todo)
}