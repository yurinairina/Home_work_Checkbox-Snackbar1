package com.example.checkboxsnackbarhomework

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var inputFieldET: EditText
    private lateinit var infoOutputTV: TextView
    private lateinit var saveBTN: Button
    private lateinit var deleteBTN: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        inputFieldET = findViewById(R.id.inputFieldET)
        infoOutputTV = findViewById(R.id.infoOutputTV)
        saveBTN = findViewById(R.id.saveBTN)
        deleteBTN = findViewById(R.id.deleteBTN)

        saveBTN.setOnClickListener { v ->
            infoOutputTV.text = inputFieldET.text.toString().uppercase()
        }
        deleteBTN.setOnClickListener { v ->
            val snackbar = Snackbar.make(v, "Подтвердите удаление", Snackbar.LENGTH_LONG)
                .setAction("Удалить") {
                    inputFieldET.text.clear()
                    infoOutputTV.text=""
                    Snackbar.make(v, "Данные удалены", Snackbar.LENGTH_LONG).show()
                }
            snackbar.show()
        }
    }
}