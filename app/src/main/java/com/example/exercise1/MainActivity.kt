package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener {

            if(editTextCarPrice.text.isEmpty() || editTextDownPayment.text.isEmpty() ||
                editTextInterestRate.text.isEmpty() || editTextLoanPeriod.text.isEmpty()){
                Toast.makeText(applicationContext,"Please Fill Up the Blank !", Toast.LENGTH_SHORT).show()
            } else {

                val price = findViewById<EditText>(R.id.editTextCarPrice).text.toString().toDouble()
                val downPayment =
                    findViewById<EditText>(R.id.editTextDownPayment).text.toString().toDouble()
                val rate =
                    (findViewById<EditText>(R.id.editTextInterestRate).text.toString().toDouble()) / 100
                val period = findViewById<EditText>(R.id.editTextLoanPeriod).text.toString().toInt()

                val loan = price - downPayment
                val interest = (loan * rate) * period
                val monthlyPayment = (loan + interest) / period / 12

                textViewLoan.text = ("Loan : RM" + String.format("%.2f", loan))
                textViewInterest.text = ("Interest : RM" + String.format("%.2f", interest))
                textViewMonthlyRepayment.text =
                    ("Monthly Repayment : RM" + String.format("%.2f", monthlyPayment))
            }
        }


        findViewById<Button>(R.id.buttonReset).setOnClickListener {

            editTextCarPrice.setText("")
            editTextDownPayment.setText("")
            editTextInterestRate.setText("")
            editTextLoanPeriod.setText("")
            textViewLoan.text=getString(R.string.loan)
            textViewInterest.text=getString(R.string.interest)
            textViewMonthlyRepayment.text=getString(R.string.monthly_repayment)
        }
    }
}
