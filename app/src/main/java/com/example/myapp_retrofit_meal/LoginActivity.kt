package com.example.myapp_retrofit_meal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class  LoginActivity : AppCompatActivity() {
    var Usermail="Rameshsagar@ibm.com"
    var Password="Ramesh123@"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener {
            val usermail=Email.text.toString()
            val password=pass.text.toString()
            if (usermail==Usermail && password==Password){
                val intent= Intent(this,MainActivity::class.java)
                intent.putExtra("usermail",usermail)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "You enter wrong details", Toast.LENGTH_SHORT).show()
            }
        }
    }
}