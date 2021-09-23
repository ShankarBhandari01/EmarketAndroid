package com.example.emarketapplication.UserInterface

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.emarketapplication.R
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {
    private lateinit var btnWelcome: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            binding()
            withContext(Main) {
                btnWelcome.setOnClickListener {
                    finish()
                    startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                }
            }
        }

    }

    private fun binding() {
        btnWelcome = findViewById(R.id.btnWelcome)
    }


}