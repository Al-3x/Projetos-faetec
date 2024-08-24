package com.example.jogodamatematica

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jogodamatematica.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // Usando View Binding para acessar as views da interface do usuário
    private lateinit var binding: ActivityMainBinding

    // Variável para rastrear a pontuação do usuário
    private var score = 0
    
    // Variável para armazenar a resposta correta da pergunta atual
    private var correctAnswer = 0

    // Método onCreate chamado quando a atividade é criada pela primeira vez
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Inicializa o objeto de binding inflando o layout associado
        binding = ActivityMainBinding.inflate(layoutInflater)
        
        // Define o conteúdo da atividade para o layout raiz da vinculação
        setContentView(binding.root)

        // Gera uma nova pergunta quando a atividade é criada
        generateQuestion()

        // Define um listener para o botão de envio que verifica a resposta quando clicado
        binding.submitButton.setOnClickListener {
            checkAnswer()
        }
    }

    // Método para gerar uma nova pergunta de adição aleatória
    private fun generateQuestion() {
        // Gera dois números aleatórios entre 1 e 9 (inclusive)
        val num1 = Random.nextInt(1, 10)
        val num2 = Random.nextInt(1, 10)
        
        // Calcula a resposta correta para a pergunta gerada
        correctAnswer = num1 + num2
        
        // Atualiza o texto do TextView para mostrar a nova pergunta
        binding.questionTextView.text = "Quanto é $num1 + $num2?"
    }

    // Método para verificar a resposta do usuário
    private fun checkAnswer() {
        // Obtém o texto da resposta do usuário a partir do EditText
        val userAnswer = binding.answerEditText.text.toString()
        
        // Verifica se a resposta não está vazia
        if (userAnswer.isNotEmpty()) {
            
            // Converte a resposta do usuário para um inteiro e compara com a resposta correta
            if (userAnswer.toInt() == correctAnswer) {
                
                // Incrementa a pontuação se a resposta estiver correta
                score++
                
                // Atualiza o TextView do resultado com uma mensagem de "Resposta Correta!"
                binding.resultTextView.text = "Resposta Correta!"
                
                // Define a cor do texto para verde para indicar uma resposta correta
                binding.resultTextView.setTextColor(getColor(R.color.green))
            } else {
                
                // Exibe uma mensagem com a resposta correta se a resposta estiver errada
                binding.resultTextView.text = "Resposta Errada! A resposta certa é $correctAnswer"
                
                // Define a cor do texto para vermelho para indicar uma resposta errada
                binding.resultTextView.setTextColor(getColor(R.color.red))
            }
            
            // Atualiza o TextView da pontuação para mostrar a pontuação atualizada
            binding.scoreTextView.text = "Pontuação: $score"
            
            // Gera uma nova pergunta para o próximo turno
            generateQuestion()
            
            // Limpa o campo de entrada de resposta para a próxima pergunta
            binding.answerEditText.text.clear()
        } else {
            // Exibe um Toast solicitando que o usuário insira uma resposta se o campo estiver vazio
            Toast.makeText(this, "Por favor, insira uma resposta", Toast.LENGTH_SHORT).show()
        }
    }
}
