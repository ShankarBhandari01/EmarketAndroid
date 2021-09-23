package com.example.emarketapplication.UserInterface

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.emarketapplication.R
import com.example.emarketapplication.modal.Users
import com.example.emarketapplication.repository.UserRepository
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignupActivity : AppCompatActivity() {
    private val language = arrayOf("Gender", "Male", "Female", "Other")
    private lateinit var spgender: Spinner
    private lateinit var tvLogin: TextView
    private lateinit var etFullname: TextInputEditText
    private lateinit var dob: TextInputEditText
    private lateinit var address: TextInputEditText
    private lateinit var phone: TextInputEditText
    private lateinit var etUsername: TextInputEditText
    private lateinit var Password: TextInputEditText
    private lateinit var ConfirmPassword: TextInputEditText
    private lateinit var btnSign: MaterialButton
    private lateinit var linearLayout3: LinearLayout
    var selected: String = "Gender"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        binding()
        tvLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        spgender.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    selected = parent?.getItemAtPosition(position).toString()

                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    //todo
                }
            }
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, language
        )
        spgender.adapter = adapter
        btnSign.setOnClickListener {
            if (Password.text.toString() != ConfirmPassword.text.toString()) {
                Password.error = "Password does not match"
                Password.requestFocus()
                return@setOnClickListener
            }
            if (etFullname.text.toString() == "") {
                etFullname.error = "please enter Full name"
                etFullname.requestFocus()
                return@setOnClickListener
            }
            if (selected == "Gender") {
                Toast.makeText(this, "Please selected the gender", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (dob.text.toString() == "") {
                dob.error = "please enter date of birth"
                dob.requestFocus()
                return@setOnClickListener
            }
            if (phone.text.toString() == "") {
                phone.error = "please enter the phone number"
                phone.requestFocus()
                return@setOnClickListener
            }
            if (etUsername.text.toString() == "") {
                etUsername.error = "please enter your username"
                etUsername.requestFocus()
                return@setOnClickListener
            }
            if (Password.text.toString() == "") {
                Password.error = "Please enter password"
                Password.requestFocus()
                return@setOnClickListener
            }
            Signup()
        }

    }

    fun binding() {
        spgender = findViewById(R.id.spgender)
        tvLogin = findViewById(R.id.tvLogin)
        etFullname = findViewById(R.id.etFullname)
        dob = findViewById(R.id.dob)
        address = findViewById(R.id.address)
        phone = findViewById(R.id.phone)
        etUsername = findViewById(R.id.etUsername)
        Password = findViewById(R.id.Password)
        ConfirmPassword = findViewById(R.id.ConfirmPassword)
        btnSign = findViewById(R.id.btnSign)
        linearLayout3 = findViewById(R.id.linearLayout3)
    }

    fun Signup() {
        val user = Users(
            fullname = etFullname.text.toString(),
            gender = selected,
            phone = phone.text.toString(),
            address = address.text.toString(),
            username = etUsername.text.toString(),
            password = Password.text.toString(),
            dob = dob.text.toString()
        )
        CoroutineScope(Dispatchers.IO).launch {
            val respository = UserRepository()
            val response = respository.signup(user)

            if (response.success == true) {
                withContext(Main) {
                    Toast.makeText(
                        this@SignupActivity,
                        "${response.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                    etFullname.text?.clear()
                }

            } else {
                withContext(Main) {
                    Toast.makeText(
                        this@SignupActivity,
                        "${response.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }


    }
}
