package com.example.restaurante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurante.databinding.ActivityPedidoBinding

class PedidoActivity : AppCompatActivity() {
    //Criação da variável binding atrelada ao PedidoActivity
    private lateinit var binding: ActivityPedidoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        //Monta a tela e liga o arquivo xml do login ao binding
        binding = ActivityPedidoBinding.inflate(layoutInflater)
        //Começa a atividade e configura o conteúdo da tela
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //Criação da constante i com o objeto intent e atribuição dessa constante para os valores das
        //quantidades de itens que foram pedidos. Usando o método getStringExtra() para extrair esses
        //valores. E depois converte esse valores de String para Int.
        val i = intent
        val quantidadePizza = i.getStringExtra("quantidadePizza").toString().toInt()
        val quantidadeSalada = i.getStringExtra("quantidadeSalada").toString().toInt()
        val quantidadeHamburguer = i.getStringExtra("quantidadeHamburguer").toString().toInt()
        //Cria uma constante texto, e faz um resumo do pedido baseado nos valores inseridos no código
        //anteriormente. E por fim atrela o binding do textResumo no xml para essa constante.
        val texto = "Resumo do Pedido\n" +
                "Pizza: $quantidadePizza Preço: ${quantidadePizza*8}\n" +
                "Salada: $quantidadeSalada Preço: ${quantidadeSalada*10}\n" +
                "Hamburguer: $quantidadeHamburguer Preço: ${quantidadeHamburguer*12}\n"

        binding.textResumo.text = texto

    }
}