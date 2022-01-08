package com.example.january6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase


private lateinit var email_input : TextInputLayout
private lateinit var password_input : TextInputLayout
private lateinit var password_repeat : TextInputLayout
private lateinit var email_input1 : EditText
private lateinit var password_input1 : EditText
private lateinit var password_repeat1 : EditText
private lateinit var signupBtn : Button
private lateinit var txtbtn : TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email_input = findViewById(R.id.email_input)
        email_input1 = findViewById(R.id.email_input1)
        password_input = findViewById(R.id.password_input)
        password_input1 = findViewById(R.id.password_input1)
        password_repeat = findViewById(R.id.password_repeat)
        password_repeat1 = findViewById(R.id.password_repeat1)
        signupBtn = findViewById(R.id.signupBtn)
        txtbtn = findViewById(R.id.txtbtn)


        signupBtn.setOnClickListener(){

            val password = password_input1.text.toString()
            val passwordRepeat = password_repeat1.text.toString()
            val email = email_input1.text.toString()


            if(email_input1.length()==0){
                email_input.error = "Please enter your email"

            }else{
                email_input.error = null
            }

            if(password_input1.length()==0){
                password_input.error = "Please enter your password"

            }else{
                password_input.error = null
            }
            if(password_repeat1.length()==0){
                password_repeat.error = "Password doesn't match"
                return@setOnClickListener
            }else{
                password_repeat.error = null
            }
            if(password != passwordRepeat){
                password_repeat.error = "Password doesn't match"

            }else{
                password_repeat.error = null

            }


            if(email_input1.length()==0){
                return@setOnClickListener

            }else{
                FirebaseAuth
                .getInstance()
                .createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener{task ->
                    if(task.isSuccessful){
                        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                        login()
                    }else{
                        Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                    }
                }

            }


        }
        txtbtn.setOnClickListener(){
            login()

        }

    }
    private fun login(){
        startActivity(Intent(this,LoginActivity::class.java))

    }
}




