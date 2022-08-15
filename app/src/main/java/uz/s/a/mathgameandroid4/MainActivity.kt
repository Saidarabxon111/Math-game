package uz.s.a.mathgameandroid4

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var mytextView: TextView
    private lateinit var myEditText: EditText
    private lateinit var myScore: TextView


    var number = 0
    var number1 = 0
    var togriJavob = 0
    var amal = 0
    var notogri = 0
    var totalS = 0
    var correctS = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        myEditText = findViewById(R.id.edt_1)
        myScore = findViewById(R.id.tv_ball)

        randomMisol()


        myEditText.addTextChangedListener {
            if (togriJavob.toString().length == it?.length) {

                val javob = myEditText.text.toString().toInt()
                if (javob == togriJavob) {
                    correctS++
                    Toast.makeText(this, "to'gri javob", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "notogri javob", Toast.LENGTH_SHORT).show()

                    notogri++
                }
                myEditText.text.clear()
                randomMisol()
            }
        }

    }

    fun randomMisol() {
        number = Random().nextInt(25)
        number1 = Random().nextInt(25)
        mytextView = findViewById(R.id.tv_1)

        if (number < number1) {
            randomMisol()
            return
        }
        amal = Random().nextInt(4)

        when (amal) {
            0 -> {

                togriJavob = number + number1
                mytextView.text = "$number+$number1="
            }
            1 -> {
                togriJavob = number - number1
                mytextView.text = "$number-$number1="
            }
            2 -> {
                togriJavob = number * number1
                mytextView.text = "$number*$number1="

            }


            3 -> {

                try {
                    if (number % number1 != 0) {
                        randomMisol()
                        return
                    }
                    togriJavob = number / number1
                    mytextView.text = "$number/$number1="


                } catch (e: Exception) {
                    randomMisol()
                }

            }

        }
        myScore.text = "$correctS/$totalS"
    }

}