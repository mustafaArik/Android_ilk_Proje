package com.example.ilkproje

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        val current = LocalDateTime.now().format(formatter)

        tasarim.saat.setText(current)
        Toast.makeText(this,"Merhaba",Toast.LENGTH_SHORT).show()

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
        var sinif = "9"
        var ders = ""
        if(tasarim.radioButton2.isChecked) sinif = "10"
        else if(tasarim.radioButton3.isChecked) sinif = "11"

        if(tasarim.checkBox.isChecked) ders = ders + " WTUG,"
        if(tasarim.checkBox2.isChecked) ders = ders + " Mobil,"
        if(tasarim.checkBox3.isChecked) ders = ders + " Yazılım Prj. "


        Toast.makeText(
            this@MainActivity,
            "Sınıfınız : $sinif \n Dersleriniz $ders",
            Toast.LENGTH_LONG
        ).show()

    }
}






















