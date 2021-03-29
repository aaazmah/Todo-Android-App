package edu.towson.cosc435.sheikh.todos

import edu.towson.cosc435.sheikh.todos.interfaces.ITodoRepository
import edu.towson.cosc435.sheikh.todos.model.Todo

class TodoRepository: ITodoRepository {


private val todos: MutableList<Todo> = mutableListOf()

init {
    todos.add(
            Todo("Todo 2", "HW", false, " 2","today")
    )
    todos.add(
            Todo("Todo 2", "School 1", false, " 1","today")
    )
    todos.add(
            Todo("Todo 3", "HW 1", false, " 1","today")
    )
    todos.add(
            Todo("Todo 4", "HW 1", false, " 1","today")
    )
    todos.add(
            Todo("Todo 5", "School 2", false, " 1","today")
    )
    todos.add(
            Todo("Todo 6", "School 1", false ," 1" ,"today")
    )
    todos.add(
            Todo("Todo 7", "School 1", false, " 1","today")
    )
    todos.add(
            Todo("Todo 8", "School 1", false, " 1","today")
    )
    todos.add(
            Todo("Todo 9", "School 1", false, " 1","today")
    )
    todos.add(
            Todo("Todo 10", "School 1", false, " 1","today")
    )



}

    override fun getCount(): Int {
        return todos.size
    }

    override fun getTodo(idx: Int): Todo {
        if (idx < 0) return todos[0]
        if (idx >= getCount()) return todos[todos.size - 1]
        return todos[idx]
    }

    override fun getTodos(): List<Todo> {
        return todos
    }

    override fun deleteTodo(idx: Int) {
        if(idx < 0 || idx >= getCount()) throw Exception("Index out of bounds")
        todos.removeAt(idx)
    }

    override fun addTodo(todo: Todo) {
        todos.add(todo)
    }


}