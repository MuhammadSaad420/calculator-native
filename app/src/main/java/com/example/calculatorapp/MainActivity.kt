package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var outputText: TextView? = null
    private var hasDot = false;
    private var lastNumeric = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        outputText = findViewById(R.id.outputText);
    }
    fun digit(view: View) {
      outputText?.append((view as Button).text);
        lastNumeric = true;
    }
    fun onClear(view: View) {
        outputText?.text ="";
         hasDot = false;
         lastNumeric = false
    }

    fun onDot(view: View) {
        if(lastNumeric && !hasDot) {
            outputText?.append(".");
            hasDot = true;
        }}
        fun onOperator(view: View) {
            if(lastNumeric && !isOperatorAdded(outputText?.text.toString())) {
                outputText?.append((view as Button).text)
                lastNumeric = false;
            }
        }
    fun onEqual(view: View) {
        try {
            if (lastNumeric) {
                print("1");
                val enteredValue = outputText?.text;
                var prefix = "";
                if (enteredValue!!.contains("-")) {
                    var subString = enteredValue;

                    if (enteredValue.startsWith("-")) {
                        prefix = "-";
                        subString = enteredValue.substring(1, enteredValue.length);
                        print(subString);

                    }
                    val enteredArray = subString.split("-");
                    val one = (prefix + enteredArray[0]).toDouble();
                    val two = enteredArray[1].toDouble();
                    val result = one - two;
                    outputText?.text = result.toString();
                }
            }
        }catch (e:java.lang.Exception) {
            print(e.stackTrace)
        }
    }


        private fun isOperatorAdded(value: String) : Boolean {
            if(value.startsWith("-")) {
                false;
            }
            else if(value.contains("+")
                || value.contains("-")
                || value.contains("*")
                || value.contains("/")) {
                return true;
                }
            return  false;
        }


}