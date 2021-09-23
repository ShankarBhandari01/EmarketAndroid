package com.example.emarketapplication.UserInterface

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.emarketapplication.R
import com.example.emarketapplication.api.ServiceBuilder.token
import com.example.emarketapplication.repository.UserRepository
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {
    lateinit var etUsername: TextInputEditText
    lateinit var Password: TextInputEditText
    lateinit var login: MaterialButton
    lateinit var signup: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding()
        login.setOnClickListener {
            login()
        }
        signup.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }

    private fun binding() {
        etUsername = findViewById(R.id.etUsername)
        Password = findViewById(R.id.Password)
        login = findViewById(R.id.btnlogin)
        signup = findViewById(R.id.tvSignup)
    }

    fun login() {
        if (etUsername.text.toString() == "" || Password.text.toString() == "") {
            if (etUsername.text.toString() == "") {
                etUsername.error = "Please enter your username"
                etUsername.requestFocus()
                return
            } else {
                Password.error = "please enter your password"
                return
            }

        } else {
            CoroutineScope(Dispatchers.IO).launch {
                val repository = UserRepository()
                val response = repository.login(
                    username = etUsername.text.toString(),
                    password = Password.text.toString()
                )
                if (response.success == true) {
                    saveSharedoPref()
                    token = response.token
                    finish()
                    startActivity(Intent(this@LoginActivity, Dashboard::class.java))
                } else {
                    withContext(Main) {
                        Toast.makeText(
                            this@LoginActivity,
                            "${response.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    private fun saveSharedoPref() {
        val userName = etUsername.text.toString()
        val password = Password.text.toString()
        val sharedpref = getSharedPreferences("Mypref", MODE_PRIVATE)
        val editor = sharedpref.edit()
        editor.putString("username", userName)
        editor.putString("password", password)
        editor.apply()
    }
}