package com.example.tipcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import com.example.tipcalc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        val etiqueta = findViewById<TextView>(R.id.button15)
        val etiqueta1 = findViewById<TextView>(R.id.button25)
        val etiqueta2 = findViewById<TextView>(R.id.button35)
        binding.button15.setOnClickListener {
            interfaceCalculateTip(0.15)
            etiqueta.text = "Le agradecemos su preferencia"
            Log.v("edu.itesm.mensaje", "test de boton propina")
            Toast.makeText(this, "Gracias por su propina", Toast.LENGTH_LONG).show()
        }

        binding.button25.setOnClickListener {
            interfaceCalculateTip(0.25)
            etiqueta1.text = "Le agradecemos su preferencia"
            Log.v("edu.itesm.mensaje", "test de boton propina")
            Toast.makeText(this, "Muchas gracias por su propina", Toast.LENGTH_LONG).show()

        }

        binding.button35.setOnClickListener {
            interfaceCalculateTip(0.35)
            etiqueta2.text = "Le agradecemos su preferencia"
            Log.v("edu.itesm.mensaje", "test de boton propina")
            Toast.makeText(this, "Dios le bendiga", Toast.LENGTH_LONG).show()
        }


    }

    private fun interfaceCalculateTip(percentage: Double) {
        val amount = binding.amountValue.text.toString()
        val amountValue = amount.toDoubleOrNull()

        if (amountValue == null) {
            binding.totalTip.text = "0.0"
            binding.totalAmount.text = "0.0"
            return
        }
        if(amountValue <= 0){
            binding.amountValue.setOnClickListener{
                Log.v("edu.itesm.mensaje", "test de boton error")
                Toast.makeText(this, "Error: ha introducido una cifra inválida, seleccione una cifra mayor a 0", Toast.LENGTH_LONG).show()
            }
            return
        }
        binding.totalTip.text = "${amountValue * percentage}"
        binding.totalAmount.text = "${amountValue * (1 + percentage)}"
        binding.switch1.setOnCheckedChangeListener { compoundButton, b ->
            if (true) {
                binding.totalAmount.text = "${kotlin.math.round(amountValue * (1 + percentage))}"
            }
        }

    }
}