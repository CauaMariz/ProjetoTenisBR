package com.example.projetotenisbr

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_screen)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.home_menu -> {
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.profile_menu -> {
                Toast.makeText(this, "Sua conta", Toast.LENGTH_SHORT).show()

                val nameUser = intent.getStringExtra("NAME_USER");
                val intentUser = Intent(this , AccountUserScreen::class.java);
                intentUser.putExtra("NAME_USER" , nameUser);
                startActivity(intentUser);
                true
            }
            R.id.carrinho_menu -> {
                Toast.makeText(this, "Seu carrinho", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.config_menu -> {
                Toast.makeText(this, "Configuracoes", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}