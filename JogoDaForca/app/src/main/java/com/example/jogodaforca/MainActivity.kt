package com.example.jogodaforca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jogodaforca.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val palavras = listOf("kotlin", "android", "desenvolvedor")
    private var palavraSelecionada = ""
    private var palavraOculta = CharArray(0)
    private var tentativas = 6
    private val letrasAdivinhadas = mutableListOf<Char>()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        iniciarJogo()

        binding.buttonAdivinhar.setOnClickListener {
            val entrada = binding.editEntrada.text.toString().uppercase()
            if (entrada.isNotEmpty()) {
                val letra = entrada[0]
                if (!letrasAdivinhadas.contains(letra)) {
                    letrasAdivinhadas.add(letra)
                    if (palavraSelecionada.contains(letra)) {
                        for (i in palavraSelecionada.indices) {
                            if (palavraSelecionada[i] == letra) {
                                palavraOculta[i] = letra
                            }
                        }
                    } else {
                        tentativas--
                    }
                    binding.editEntrada.text.clear()
                    atualizarTela()
                }
            }
        }

        binding.buttonReiniciar.setOnClickListener {
            iniciarJogo() // Reinicia o jogo quando o botão é clicado
        }
    }

    private fun iniciarJogo() {
        palavraSelecionada = palavras.random().uppercase()
        palavraOculta = CharArray(palavraSelecionada.length) { '_' }
        tentativas = 6
        letrasAdivinhadas.clear()

        binding.buttonAdivinhar.isEnabled = true
        binding.buttonReiniciar.visibility = android.view.View.GONE
        binding.textStatus.text = ""

        atualizarTela()
    }

    private fun atualizarTela() {
        binding.textOculto.text = palavraOculta.joinToString(" ")
        binding.textTentativas.text = "Restam: $tentativas"

        // Atualiza o progresso da ProgressBar
        val progresso = calcularProgresso()
        binding.progressBarCircular.progress = progresso

        if (!palavraOculta.contains('_')) {
            binding.textStatus.text = "Parabéns! $palavraSelecionada"
            binding.buttonAdivinhar.isEnabled = false
            binding.progressBarCircular.progress = 100
            binding.buttonReiniciar.visibility = android.view.View.VISIBLE
        } else if (tentativas <= 0) {
            binding.textStatus.text = "Perdeu! Era $palavraSelecionada"
            binding.buttonAdivinhar.isEnabled = false
            binding.buttonReiniciar.visibility = android.view.View.VISIBLE
        }
    }

    private fun calcularProgresso(): Int {
        val letrasCorretas = palavraOculta.count { it != '_' }
        return (letrasCorretas.toFloat() / palavraSelecionada.length * 100).toInt()
    }
}
