package edu.towson.cosc435.sheikh.todos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import com.google.gson.Gson
import edu.towson.cosc435.sheikh.todos.model.Todo
import java.lang.Exception

class NewTodoActivity : AppCompatActivity() {

    private lateinit var saveButton: Button
    private lateinit var titleView: EditText
    private lateinit var content: EditText
    private lateinit var isComplete: CheckBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_todo)

        grabWidgets()

        saveButton = findViewById(R.id.saveButton)
        saveButton.setOnClickListener{
            val intent = Intent()

            try {
                val info = Todo(
                        title = titleView.editableText.toString(),
                        contents = content.editableText.toString(),
                        isCompleted = isComplete.isChecked,
                        image = "image",
                        dateCreated = "00/00/00"
                )
                val json = Gson().toJson(info)
                intent.putExtra(INFO_KEY, json)
                setResult(RESULT_OK, intent)
                finish()
            } catch (e: Exception){
                if(e.message != null) {
                    Log.d(TAG, e.message!!)
                }

            }

        }
    }

    private fun grabWidgets(){
        // The launchButton variable now holds the launchactivity button from the layout
        saveButton = findViewById(R.id.saveButton)
        titleView = findViewById(R.id.EditTitle)
        content = findViewById(R.id.MultiLineText)
        isComplete = findViewById(R.id.checkBox)

    }


    companion object{
        const val INFO_KEY = "info_key"
        val TAG = NewTodoActivity::class.java.simpleName
    }





}