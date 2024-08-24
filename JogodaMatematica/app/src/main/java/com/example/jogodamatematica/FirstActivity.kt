package com.example.jogodamatematica

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jogodamatematica.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

    // Definindo a variável de binding
    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflando o layout usando View Binding
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurando o listener de clique do botão
        binding.startGameButton.setOnClickListener {
            // Ação ao clicar no botão "Iniciar Jogo"
            openMainActivity()
        }
    }

    private fun openMainActivity() {
        // Iniciar a MainActivity
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}