package com.example.jogodamatematica

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jogodamatematica.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

    // Definindo a variável de binding para acessar as views da interface do usuário
    private lateinit var binding: ActivityStartBinding

    // Método onCreate chamado quando a atividade é criada pela primeira vez
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Inflando o layout associado com o binding, permitindo o acesso às views sem findViewById
        binding = ActivityStartBinding.inflate(layoutInflater)
        
        // Define o conteúdo da atividade para o layout raiz da vinculação
        setContentView(binding.root)

        // Configurando o listener de clique para o botão "Iniciar Jogo"
        binding.startGameButton.setOnClickListener {
            // Chama o método para abrir a MainActivity ao clicar no botão
            openMainActivity()
        }
    }

    // Método para iniciar a MainActivity
    private fun openMainActivity() {
        // Cria uma intent para iniciar a MainActivity
        val intent = Intent(this, MainActivity::class.java)
        
        // Inicia a MainActivity usando a intent criada
        startActivity(intent)
    }
}
