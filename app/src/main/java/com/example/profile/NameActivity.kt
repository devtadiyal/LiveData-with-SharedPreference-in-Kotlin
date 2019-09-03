package com.example.profile

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class NameActivity : AppCompatActivity() {

    private lateinit var model: NameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Other code to setup the activity...

        // Get the ViewModel.
        model = ViewModelProviders.of(this)
            .get(NameViewModel::class.java)


        // Create the observer which updates the UI.
        val nameObserver = Observer<String> { newName ->
            // Update the UI, in this case, a TextView.
            show.text = newName
            SharedPreference(this).save("name",newName)
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.currentName.observe(this, nameObserver)


        press.setOnClickListener {
            val anotherName = "John Doe"
            model.currentName.setValue(anotherName)
            SharedPreference(this).getValueString("name")
            Toast.makeText(this,SharedPreference(this).getValueString("name"),Toast.LENGTH_LONG).show()
        }
    }
}