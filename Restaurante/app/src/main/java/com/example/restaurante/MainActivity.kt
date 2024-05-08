package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Se cria a variável binding
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater) //Estrutura a tela e conecta o arquivo
        //xml do login ao binding
        super.onCreate(savedInstanceState)//Esse código abaixo inicializa a atividade e configura o
        //conteúdo da tela
        setContentView(binding.root)

        /*Declara a constante username usando o intent para obter o valor de username se a chave
        * username estiver presente no extras do intent, a variável intent conterá esse valor
        * caso contrário será null*/
        val username = intent.extras?.getString("username")
        //Esse código tem uma condição que verifica se a variável username está vazia ou nula
        //Assim, cumprimenta o usuário pelo nome, se o nome foi fornecido.
        if(!username.isNullOrEmpty()){
            binding.textOla.setText("Olá $username")
        }
        //Esse código faz com que o aplicativo feche completamente quando o botão buttonFechar é clicado.
        binding.buttonFechar.setOnClickListener {
            finishAffinity()
        }
        //Criação da constante intent e leitura a partir do binding dos nomes inseridos e do buttonPedir.
        binding.buttonPedir.setOnClickListener{
            val i = Intent(this, SplashActivity:: class.java)
            i.putExtra("quantidadePizza", binding.editQuantidadePizza.text.toString())
            i.putExtra("quantidadeSalada", binding.editQuantidadeSalada.text.toString())
            i.putExtra("quantidadeHamburguer", binding.editQuantidadeHamburguer.text.toString())
            startActivity(i)
            finish()
        }
        //O código está vinculando a visibilidade e a quantidade de pizzas selecionadas ao estado do
        //CheckBox. Quando o usuário marca o CheckBox, a quantidade muda para 1 e o preço é
        //mostrado. Quando o usuário desmarca o CheckBox, a quantidade volta para 0 e o preço é ocultado.
        binding.checkPizza.setOnClickListener {
            if(binding.checkPizza.isChecked()){
                binding.editQuantidadePizza.setText("1")
                binding.textPrecoPizza.visibility = View.VISIBLE
            }else{
                binding.editQuantidadePizza.setText("0")
                binding.textPrecoPizza.visibility = View.GONE
            }
        }
        //Este código é muito similar ao anterior, com a diferença de que a pizza nesse caso vira salada.
        binding.checkSalada.setOnClickListener {
            if(binding.checkSalada.isChecked()){
                binding.editQuantidadeSalada.setText("1")
                binding.textPrecoSalada.visibility = View.VISIBLE
            }else{
                binding.editQuantidadeSalada.setText("0")
                binding.textPrecoSalada.visibility = View.GONE
            }
        }
        //Mesmo caso dos dois códigos anteriores, muito similar com a única diferença sendo a opção hambúrguer.
        binding.checkHamburger.setOnClickListener {
            if(binding.checkHamburger.isChecked()){
                binding.editQuantidadeHamburguer.setText("1")
                binding.textPrecoHamburguer.visibility = View.VISIBLE
            }else{
                binding.editQuantidadeHamburguer.setText("0")
                binding.textPrecoHamburguer.visibility = View.GONE
            }
        }

    }
}