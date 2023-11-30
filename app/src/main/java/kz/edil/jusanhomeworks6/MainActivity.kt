package kz.edil.jusanhomeworks6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

const val CORRECT_PIN = "1567"

class MainActivity : AppCompatActivity() {

    private var pinText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initNumButtons()
        initBackspaceButton()
        initOkButton()
    }

    fun initNumButtons() {

        val btnOne: Button = findViewById(R.id.btn_one)
        btnOne.setOnClickListener(this::onNumButtonClick)

        val btnTwo: Button = findViewById(R.id.btn_two)
        btnTwo.setOnClickListener(this::onNumButtonClick)

        val btnThree: Button = findViewById(R.id.btn_three)
        btnThree.setOnClickListener(this::onNumButtonClick)

        val btnFour: Button = findViewById(R.id.btn_four)
        btnFour.setOnClickListener(this::onNumButtonClick)

        val btnFive: Button = findViewById(R.id.btn_five)
        btnFive.setOnClickListener(this::onNumButtonClick)

        val btnSix: Button = findViewById(R.id.btn_six)
        btnSix.setOnClickListener(this::onNumButtonClick)

        val btnSeven: Button = findViewById(R.id.btn_seven)
        btnSeven.setOnClickListener(this::onNumButtonClick)

        val btnEight: Button = findViewById(R.id.btn_eight)
        btnEight.setOnClickListener(this::onNumButtonClick)

        val btnNine: Button = findViewById(R.id.btn_nine)
        btnNine.setOnClickListener(this::onNumButtonClick)

        val btnZero: Button = findViewById(R.id.btn_zero)
        btnZero.setOnClickListener(this::onNumButtonClick)
    }

    fun initBackspaceButton() {
        val btnBackspace: Button = findViewById(R.id.btn_backspace)
        btnBackspace.setOnClickListener {
        pinText = pinText.dropLast(1)
        updateTextView()
        }
    }

    fun initOkButton() {
        val btnOk: Button = findViewById(R.id.btn_ok)
        btnOk.setOnClickListener { CheckIfPinIsCorrect() }
            }

    fun CheckIfPinIsCorrect(){
        if (pinText == CORRECT_PIN){
            Toast.makeText(this, R.string.pin_is_correct, Toast.LENGTH_LONG).show()
        }
    }

    fun onNumButtonClick(view: View){
        if (view !is Button){
            return
        }

        val clickedNum = view.text
        pinText += clickedNum

        updateTextView()
    }

    fun updateTextView() {
        val tvPin: TextView = findViewById(R.id.tv_pin)
        tvPin.text = pinText
    }

}
