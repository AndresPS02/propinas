package com.example.tipcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.tipcalc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        setContentView(R.layout.activity_main)
        val etiqueta = findViewById<TextView>(R.id.button15)
        val buton = findViewById<Button>(R.id.button15)
        val etiqueta1 = findViewById<TextView>(R.id.button25)
        val buton1 = findViewById<Button>(R.id.button25)
        val etiqueta2 = findViewById<TextView>(R.id.button35)
        val buton2 = findViewById<Button>(R.id.button35)
        buton.setOnClickListener{
            etiqueta.text = "Le agradecemos su preferencia"
            Log.v("edu.itesm.mensaje", "test de boton propina")
            Toast.makeText(this, "Gracias por su propina", Toast.LENGTH_LONG).show()
        }
        buton1.setOnClickListener{
            etiqueta1.text = "Le agradecemos su preferencia"
            Log.v("edu.itesm.mensaje", "test de boton propina")
            Toast.makeText(this, "Muchas gracias por su propina", Toast.LENGTH_LONG).show()
        }
        buton2.setOnClickListener{
            etiqueta2.text = "Le agradecemos su preferencia"
            Log.v("edu.itesm.mensaje", "test de boton propina")
            Toast.makeText(this, "Dios le bendiga", Toast.LENGTH_LONG).show()
        }



    }

    private fun initUI() {
        binding.button15.setOnClickListener {
            interfaceCalculateTip(0.15)
        }

        binding.button25.setOnClickListener {
            interfaceCalculateTip(0.25)
        }

        binding.button35.setOnClickListener {
            interfaceCalculateTip(0.35)
        }


    }

    private fun interfaceCalculateTip(percentage: Double) {
        val amount = binding.editTextNumberDecimal.text.toString()
        val amountValue = amount.toDoubleOrNull()
        if (amountValue == null) {
            binding.totalTip.text = "0.0"
            binding.totalAmount.text = "0.0"
            return
        }
        binding.totalTip.text = "${amountValue * percentage}"
        binding.totalAmount.text = "${amountValue * (1 + percentage)}"
    }
}