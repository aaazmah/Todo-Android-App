package edu.towson.cosc435.sheikh.todos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import edu.towson.cosc435.sheikh.todos.interfaces.ITodoController
import edu.towson.cosc435.sheikh.todos.model.Todo


class MainActivity : AppCompatActivity(), ITodoController {

    // Initialize a variable that contains a button property
    private lateinit var addTodoButton: Button
    private lateinit var  recyclerView: RecyclerView
    private lateinit var todosRepository: TodoRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        grabWidgets()
        addTodoButton.setOnClickListener {launchActivity()}

        recyclerView.adapter = todoAdapter(this)

        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    // Separate function to hold all the widgets
    private fun grabWidgets(){
        // The launchButton variable now holds the launchactivity button from the layout

        addTodoButton = findViewById(R.id.addTodoBtn)
        recyclerView = findViewById(R.id.recyclerView)
        todosRepository = TodoRepository()


    }

    private fun launchActivity(){
        val intent = Intent(this, NewTodoActivity::class.java)
        startActivityForResult(intent, REQUEST_CODE)
    }

    // Override to get the data back
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            REQUEST_CODE -> {
                when (resultCode) {
                    RESULT_OK -> {
                        val json = data?.getStringExtra(NewTodoActivity.INFO_KEY)
                        if (json != null) {
                            val todo = Gson().fromJson<Todo>(json, Todo::class.java)
                            todosRepository.addTodo(todo)
                            recyclerView.adapter?.notifyDataSetChanged()
                            recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
                        }
                    }
                }
            }
        }
    }



    override fun deleteTodo(idx: Int) {
       todosRepository.deleteTodo(idx)
    }

    override fun editTodo(idx: Int) {
        TODO("Not yet implemented")
    }

    override fun markCompleted(idx: Int) {
        val todo = todosRepository.getTodo( idx)
        todosRepository
    }

    override fun getTodo(idx: Int): Todo {
        return todosRepository.getTodo(idx)
    }

    override fun getTodos(): List<Todo> {
        return todosRepository.getTodos()
    }



    companion object {
        const val REQUEST_CODE = 1;
        const val TAG = "MainActivity"
    }



}