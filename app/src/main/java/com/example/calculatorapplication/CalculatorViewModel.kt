package com.example.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    private val _result = MutableLiveData<String>()
    val result: LiveData<String> get() = _result

    private var currentInput = ""
    private var previousInput = ""
    private var operator = ""

    init {
        _result.value = "0"
    }

    fun onDigitClick(digit: String) {
        if (currentInput == "0") {
            currentInput = digit
        } else {
            currentInput += digit
        }
        _result.value = currentInput
    }

    fun onOperatorClick(op: String) {
        if (currentInput.isNotEmpty()) {
            if (previousInput.isEmpty()) {
                previousInput = currentInput
                currentInput = ""
            }
            operator = op
        }
    }

    fun onEqualClick() {
        if (previousInput.isNotEmpty() && currentInput.isNotEmpty() && operator.isNotEmpty()) {
            val num1 = previousInput.toDoubleOrNull()
            val num2 = currentInput.toDoubleOrNull()

            if (num1 != null && num2 != null) {
                val result = when (operator) {
                    "+" -> num1 + num2
                    "-" -> num1 - num2
                    "*" -> num1 * num2
                    "/" -> if (num2 != 0.0) num1 / num2 else Double.NaN
                    else -> 0.0
                }
                currentInput = result.toString()
                previousInput = ""
                operator = ""
                _result.value = currentInput
            }
        }
    }

    fun onClearClick() {
        currentInput = ""
        previousInput = ""
        operator = ""
        _result.value = "0"
    }
}
