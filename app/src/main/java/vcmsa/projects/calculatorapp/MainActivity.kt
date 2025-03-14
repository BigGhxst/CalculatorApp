package vcmsa.projects.calculatorapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val Clearbtn = findViewById<Button>(R.id.btn)
        val num0 = findViewById<Button>(R.id.zero)
        val num1 = findViewById<Button>(R.id.one)
        val num2 = findViewById<Button>(R.id.two)
        val num3 = findViewById<Button>(R.id.three)
        val num4 = findViewById<Button>(R.id.four)
        val num5 = findViewById<Button>(R.id.five)
        val num6 = findViewById<Button>(R.id.six)
        val num7 = findViewById<Button>(R.id.seven)
        val num8 = findViewById<Button>(R.id.eight)
        val num9 = findViewById<Button>(R.id.nine)
        val answer = findViewById<Button>(R.id.equal)
        val addition = findViewById<Button>(R.id.Add)
        val Subtract = findViewById<Button>(R.id.Sub)
        val Multiply = findViewById<Button>(R.id.Mult)
        val Divide = findViewById<Button>(R.id.Div)
        val Display = findViewById<TextView>(R.id.textView)


        var currentInput = StringBuilder()
        var firstNumber = ""
        var secondNumber = ""
        var operator = ""


        val numberButtons = listOf(num0, num1, num2, num3, num4, num5, num6, num7, num8, num9)


        numberButtons.forEach { button ->
            button.setOnClickListener {
                currentInput.append(button.text.toString())
                Display.text = currentInput.toString()
            }
        }


        addition.setOnClickListener {
            if (currentInput.isNotEmpty()) {
                firstNumber = currentInput.toString()
                operator = "+"
                currentInput.append(" + ")
                Display.text = currentInput.toString()
            }
        }

        Subtract.setOnClickListener {
            if (currentInput.isNotEmpty()) {
                firstNumber = currentInput.toString()
                operator = "-"
                currentInput.append(" - ")
                Display.text = currentInput.toString()
            }
        }

        Multiply.setOnClickListener {
            if (currentInput.isNotEmpty()) {
                firstNumber = currentInput.toString()
                operator = "*"
                currentInput.append(" * ")
                Display.text = currentInput.toString()
            }
        }

        Divide.setOnClickListener {
            if (currentInput.isNotEmpty()) {
                firstNumber = currentInput.toString()
                operator = "/"
                currentInput.append(" / ")
                Display.text = currentInput.toString()
            }
        }


        answer.setOnClickListener {
            if (operator.isNotEmpty() && currentInput.isNotEmpty()) {
                val parts = currentInput.toString().split(" $operator ")
                if (parts.size == 2) {
                    firstNumber = parts[0]
                    secondNumber = parts[1]


                    val result = when (operator) {
                        "+" -> firstNumber.toDouble() + secondNumber.toDouble()
                        "-" -> firstNumber.toDouble() - secondNumber.toDouble()
                        "*" -> firstNumber.toDouble() * secondNumber.toDouble()
                        "/" -> if (secondNumber.toDouble() != 0.0) {
                            firstNumber.toDouble() / secondNumber.toDouble()
                        } else {
                            Toast.makeText(this, "Division by 0 is not allowed", Toast.LENGTH_SHORT).show()
                            return@setOnClickListener
                        }
                        else -> "Error"
                    }


                    Display.text = "$firstNumber $operator $secondNumber = $result"


                    currentInput.clear()
                    firstNumber = ""
                    secondNumber = ""
                    operator = ""
                }
            }
        }


        Clearbtn.setOnClickListener {
            currentInput.clear()
            firstNumber = ""
            secondNumber = ""
            operator = ""
            Display.text = "0"
        }
    }
}
