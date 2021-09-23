package com.example.emarketapplication.UserInterface

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CheckActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        saveSharedPref()


    }

    private fun saveSharedPref() {
        CoroutineScope(Dispatchers.IO).launch {
            val sharedpref = getSharedPreferences("Mypref", MODE_PRIVATE)
            if (sharedpref.getBoolean("First_time", true)) {
                startActivity(Intent(this@CheckActivity, MainActivity::class.java))
                sharedpref.edit().putBoolean("First_time", false).apply()
            } else {
                startActivity(Intent(this@CheckActivity, SplashScreenActivity::class.java))
            }
        }


    }

}