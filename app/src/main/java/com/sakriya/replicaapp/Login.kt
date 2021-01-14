package com.sakriya.replicaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Login : AppCompatActivity() {

    private lateinit var etUser : EditText
    private lateinit var etPass: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUser = findViewById(R.id.etUser)
        etPass = findViewById(R.id.etPass)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            if(etUser.text.toString() == "admin" || etPass.text.toString() == "admin")
            {
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}