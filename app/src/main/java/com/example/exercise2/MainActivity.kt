package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var BIM_pic : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate: Button = findViewById(R.id.buttonCalculate)
        btnCalculate.setOnClickListener {onCalculateBMI()}

        val btnClear: Button = findViewById(R.id.buttonReset)
        btnClear.setOnClickListener {onClear()}

        BIM_pic = findViewById(R.id.imageViewProfile)

    }

    private fun onCalculateBMI() {
        val weight: EditText = findViewById(R.id.editTextWeight)
        val height: EditText = findViewById(R.id.editTextHeight)

        val valueBMI = weight.text.toString().toDouble() / ((height.text.toString().toDouble()/100) * (height.text.toString().toDouble()/100))

        textBMI.text = valueBMI.toString()

        if(valueBMI < 18.5){
            val underWeight = valueBMI
            val BIMResource = when (valueBMI) {
                underWeight.toDouble() -> R.drawable.under
                else  -> R.drawable.empty
            }
            BIM_pic.setImageResource(BIMResource)
        }else if(valueBMI >= 18.5 && valueBMI <= 24.9){
            val normal = valueBMI
            val BIMResource = when (valueBMI) {
                normal.toDouble() -> R.drawable.normal
                else  -> R.drawable.empty
            }
            BIM_pic.setImageResource(BIMResource)
        }else {
            val overWeight = valueBMI
            val BIMResource = when (valueBMI) {
                overWeight.toDouble() -> R.drawable.over
                else  -> R.drawable.empty
            }
            BIM_pic.setImageResource(BIMResource)
        }
    }

    private fun onClear(){
        val weight: EditText = findViewById(R.id.editTextWeight)
        weight.text = null
        val height: EditText = findViewById(R.id.editTextHeight)
        height.text = null

        val vBIM: TextView = findViewById(R.id.textBMI)
        vBIM.text = null
    }
}
