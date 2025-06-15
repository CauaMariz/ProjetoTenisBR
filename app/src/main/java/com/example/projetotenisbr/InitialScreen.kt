package com.example.projetotenisbr

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InitialScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.initial_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    fun enterMainScreen(view: View){
        val emailUser = findViewById<EditText>(R.id.emailUser).text.toString().trim();
        val passUser = findViewById<EditText>(R.id.passUser).text.toString().trim();
        if(emailUser.isEmpty()){
            val alert = AlertDialog.Builder(this)
                .setTitle("Aviso")
                .setMessage("Por favor, insira seu email.")
                .setPositiveButton("Ok"){dialog, _ -> dialog.dismiss()}
                .create()

            alert.show();
        }
        else if(passUser.isEmpty()){
            val alert = AlertDialog.Builder(this)
                .setTitle("Aviso")
                .setMessage("Por favor, insira sua senha.")
                .setPositiveButton("Ok"){dialog, _ -> dialog.dismiss()}
                .create()

            alert.show();
        }
        else{
            val intent =  Intent(this, MainScreen::class.java);
            startActivity(intent);
        }
    }
}