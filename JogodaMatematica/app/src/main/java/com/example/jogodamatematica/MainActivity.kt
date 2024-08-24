package com.example.jogodamatematica

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jogodamatematica.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var score = 0
    private var correctAnswer = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        generateQuestion()

        binding.submitButton.setOnClickListener {
            checkAnswer()
        }
    }

    private fun generateQuestion() {
        val num1 = Random.nextInt(1, 10)
        val num2 = Random.nextInt(1, 10)
        correctAnswer = num1 + num2
        binding.questionTextView.text = "Quanto é $num1 + $num2?"
    }

    private fun checkAnswer() {
        val userAnswer = binding.answerEditText.text.toString()
        if (userAnswer.isNotEmpty()) {
            if (userAnswer.toInt() == correctAnswer) {
                score++
                binding.resultTextView.text = "Resposta Correta!"
                binding.resultTextView.setTextColor(getColor(R.color.green))
            } else {
                binding.resultTextView.text = "Resposta Errada! A resposta certa é $correctAnswer"
                binding.resultTextView.setTextColor(getColor(R.color.red))
            }
            binding.scoreTextView.text = "Pontuação: $score"
            generateQuestion()
            binding.answerEditText.text.clear()
        } else {
            Toast.makeText(this, "Por favor, insira uma resposta", Toast.LENGTH_SHORT).show()
        }
    }
}
