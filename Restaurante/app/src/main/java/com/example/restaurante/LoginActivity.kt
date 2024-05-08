package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    //Criação da variável binding
    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Monta a tela e liga o arquivo xml do login ao binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        //Inicializa a atividade e configura o conteúdo da tela
        setContentView(binding.root)
        //Cria duas constantes que são ativadas ao apertar do botão
        binding.buttonEntrar.setOnClickListener {
            val username = binding.editUsername.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()
            //Impõe uma condição às constantes anteriores, com elas só funcionando sob essas condições
            if (username.equals("abc") && password.equals("123")) {
                //Cria uma constante Intent
                val i = Intent(this, MainActivity::class.java)
                /*
                / Adiciona um extra à Intent, que é um par chave-valor usado
                para passar dados entre componentes.
                 */
                i.putExtra("username", username)
                //Inicia a atividade do intent i e o finaliza.
                startActivity(i)
                finish()
            } else {
                Toast.makeText(applicationContext, "Errou", Toast.LENGTH_LONG).show()
            }
        }

    }
}