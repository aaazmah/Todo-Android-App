package edu.towson.cosc435.sheikh.todos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.lang.Exception


class MainActivity : AppCompatActivity(), View.OnClickListener {

    // Initialize a variable that contains a button property
    private lateinit var launchButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        grabWidgets()

        launchButton.setOnClickListener(this)


    }

    // Separate function to hold all the widgets
    private fun grabWidgets(){
        // The launchButton variable now holds the launchactivity button from the layout
        launchButton = findViewById(R.id.launchActivity)


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
                when(resultCode){
                    RESULT_OK -> {
                        val json = data?.getStringExtra(NewTodoActivity.INFO_KEY)
                        if (json != null){
                            Log.d(TAG, json)
                        }
                    }
                }
            }
        }
    }



    companion object {
        const val REQUEST_CODE = 1;
        const val TAG = "MainActivity"
    }

    override fun onClick(view: View?) {
        try {
            when(view?.id){
                R.id.launchActivity -> launchActivity()
            }
        }catch (e: Exception){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
    }


}