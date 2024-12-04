package com.example.calculatorapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.calculator.CalculatorViewModel
import com.example.calculatorapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Use View Binding
    private lateinit var binding: ActivityMainBinding
    private val calculatorViewModel: CalculatorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Observe the result from ViewModel
        calculatorViewModel.result.observe(this, Observer { result ->
            binding.tvDisplay.text = result  // Access the TextView via View Binding
        })

        // Set click listeners for buttons
        binding.btn0.setOnClickListener { onDigitClick(it) }
        binding.btn1.setOnClickListener { onDigitClick(it) }
        binding.btn2.setOnClickListener { onDigitClick(it) }
        binding.btn3.setOnClickListener { onDigitClick(it) }
        binding.btn4.setOnClickListener { onDigitClick(it) }
        binding.btn5.setOnClickListener { onDigitClick(it) }
        binding.btn6.setOnClickListener { onDigitClick(it) }
        binding.btn7.setOnClickListener { onDigitClick(it) }
        binding.btn8.setOnClickListener { onDigitClick(it) }
        binding.btn9.setOnClickListener { onDigitClick(it) }
        binding.btnAdd.setOnClickListener { onOperatorClick(it) }
        binding.btnSubtract.setOnClickListener { onOperatorClick(it) }
        binding.btnMultiply.setOnClickListener { onOperatorClick(it) }
        binding.btnDivide.setOnClickListener { onOperatorClick(it) }
        binding.btnClear.setOnClickListener { onClearClick(it) }
        binding.btnEqual.setOnClickListener { onEqualClick(it) }
    }

    // Handle digit button clicks
    fun onDigitClick(view: View) {
        val button = view as Button
        calculatorViewModel.onDigitClick(button.text.toString())
    }

    // Handle operator button clicks
    fun onOperatorClick(view: View) {
        val button = view as Button
        calculatorViewModel.onOperatorClick(button.text.toString())
    }

    // Handle equal button click
    fun onEqualClick(view: View) {
        calculatorViewModel.onEqualClick()
    }

    // Handle clear button click
    fun onClearClick(view: View) {
        calculatorViewModel.onClearClick()
    }
}
