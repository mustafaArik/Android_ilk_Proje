package com.example.ilkproje

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ilkproje.databinding.ActivityMainBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    private lateinit var tasarim : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityMainBinding.inflate(layoutInflater)
        val view = tasarim.root
        setContentView(view)

        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        val current = LocalDateTime.now().format(formatter)

        tasarim.saat.setText(current)


        tasarim.textView.text = "Program açıldı"
        /*
                tasarim.button.setOnClickListener{
                    tasarim.textView.text = "Butona tıklandı"
                }

                var metin = findViewById<TextView>(R.id.textView)
                metin.text = "Program Açıldı"
        */
    }

    fun tikla_buton(view: View)
    {
        tasarim.textView.text = "Butona tıklandı. Fonksiyon çalıştı"
    }
}