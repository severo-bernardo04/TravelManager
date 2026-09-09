package com.example.travelmanager

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editDestination: EditText
    private lateinit var editDepartureDate: EditText
    private lateinit var editReturnDate: EditText
    private lateinit var radioGroupPreference: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editDestination = findViewById(R.id.editDestination)
        editDepartureDate = findViewById(R.id.editDepartureDate)
        editReturnDate = findViewById(R.id.editReturnDate)
        radioGroupPreference = findViewById(R.id.radioGroupPreference)

        findViewById<android.widget.Button>(R.id.btnConfirm).setOnClickListener {
            onConfirmClicked()
        }
    }

    private fun onConfirmClicked() {
        val destination = editDestination.text.toString()
        val departureDate = editDepartureDate.text.toString()
        val returnDate = editReturnDate.text.toString()
        val preference = getSelectedRadioText(radioGroupPreference)

        Log.d(TAG, "Screen 1 -> Screen 2 | destination=$destination " +
                "| departureDate=$departureDate | returnDate=$returnDate | preference=$preference")

        val intent = Intent(this, ActivityListActivity::class.java).apply {
            putExtra("destination", destination)
            putExtra("departureDate", departureDate)
            putExtra("returnDate", returnDate)
            putExtra("preference", preference)
        }
        startActivity(intent)
    }

    private fun getSelectedRadioText(radioGroup: RadioGroup): String {
        val selectedId = radioGroup.checkedRadioButtonId
        val selectedButton = findViewById<android.widget.RadioButton>(selectedId)
        return selectedButton.text.toString()
    }

    companion object {
        private const val TAG = "TravelPlanner"
    }
}