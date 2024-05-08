package com.example.restaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.coroutines.delay

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Carrega o layout, define a UI da atividade e infla o layout.
        setContentView(R.layout.activity_splash)
        //Após um atraso de 2 segundos, o código inicia a PedidoActivity, passando para ela dados
        //extras que estavam presentes no Intent original.
        Handler(Looper.getMainLooper()).postDelayed({
            val i = intent
            val j = Intent(this, PedidoActivity:: class.java)
            j.putExtras(i)
            startActivity(j)
        }, 2000)



    }
}