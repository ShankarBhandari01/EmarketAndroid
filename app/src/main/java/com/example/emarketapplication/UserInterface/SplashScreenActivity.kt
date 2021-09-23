package com.example.emarketapplication.UserInterface


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.emarketapplication.R
import com.example.emarketapplication.api.ServiceBuilder.token
import com.example.emarketapplication.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        CoroutineScope(Dispatchers.IO).launch {
            val sharePref = getSharedPreferences("Mypref", MODE_PRIVATE)
            val username = sharePref.getString("username", "")
            val password = sharePref.getString("password", "")
            try {
                val repository = UserRepository()
                val response =
                    repository.login(username = username.toString(), password = password.toString())
                if (response.success == true) {
                    token = response.token
                    startActivity(Intent(this@SplashScreenActivity, Dashboard::class.java))
                } else {
                    startActivity(Intent(this@SplashScreenActivity, LoginActivity::class.java))
                }
            } catch (E: Exception) {
                withContext(Main) {
                    Toast.makeText(
                        this@SplashScreenActivity,
                        "{${E.localizedMessage}",
                        Toast.LENGTH_LONG
                    ).show()
                }

            }

        }
    }


}