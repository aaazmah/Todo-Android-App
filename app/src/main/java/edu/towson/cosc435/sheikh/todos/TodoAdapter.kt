package edu.towson.cosc435.sheikh.todos

import android.system.Os.remove
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import edu.towson.cosc435.sheikh.todos.interfaces.ITodoController
import edu.towson.cosc435.sheikh.todos.model.Todo

class todoAdapter(val controller: ITodoController) : RecyclerView.Adapter<TodoViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.todo_view, parent, false)
        val holder = TodoViewHolder(view)
        holder.onLongClick(view)
        holder.todoIsCompletecb?.setOnClickListener {
            val position = holder.adapterPosition
            controller.markCompleted(position)
            notifyItemChanged(position)
        }
        return  holder
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = controller.getTodo(position)
        holder.bindTodo(todo)
    }

    override fun getItemCount(): Int {
        return controller.getTodos().size
    }


}


class TodoViewHolder(view: View ) : RecyclerView.ViewHolder(view), View.OnLongClickListener{
    private val todoTitleTextView = itemView.findViewById<TextView>(R.id.titleContent)
    private val todoContentTextView = itemView.findViewById<TextView>(R.id.todoContent)
    val todoIsCompletecb: CheckBox ? = itemView.findViewById(R.id.checkBox2)

    fun bindTodo(todo: Todo){
        todoTitleTextView.text = todo.title
        todoContentTextView.text = todo.contents
        todoIsCompletecb?.isChecked = todo.isCompleted

    }



    init {
        view.setOnLongClickListener(this)
    }


    override fun onLongClick(view: View): Boolean {
        Toast.makeText(view.context, "long click", Toast.LENGTH_SHORT).show()
        return true
    }


}

