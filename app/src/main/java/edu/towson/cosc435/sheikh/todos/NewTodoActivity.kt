package edu.towson.cosc435.sheikh.todos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.gson.Gson
import edu.towson.cosc435.sheikh.todos.model.Todo

class NewTodoActivity : AppCompatActivity() {

    private lateinit var saveButton: Button
    private lateinit var titleView: View
    private lateinit var content: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_todo)




        saveButton = findViewById(R.id.saveButton)
        saveButton.setOnClickListener{
            val intent = Intent()
            val info = Todo(
                    title = "Things to do",
                    contents = "I have to do all my homeowrk",
                    isCompleted = true,
                    image = "image",
                    dateCreated = "00/00/00"
            )
            val json = Gson().toJson(info)
            intent.putExtra(INFO_KEY, json)
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    private fun grabWidgets(){
        // The launchButton variable now holds the launchactivity button from the layout
        saveButton = findViewById(R.id.saveButton)
        titleView = findViewById(R.id.EditTitle)
        content = findViewById(R.id.MultiLineText)


    }


    companion object{
        const val INFO_KEY = "info_key"
    }





}