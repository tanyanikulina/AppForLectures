package com.example.applectureone

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.applectureone.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var myCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val sb = StringBuilder()
        sb.append("bnm")
        sb.append("\n").append("* ").append("ghjkl")
        sb.append(true)
        sb.toString()

        binding.et.doAfterTextChanged {
            val l: Int = it?.length ?: 0
            binding.tvText.text = "Editable size: $l"
        }

        myCount = 5

        binding.button.setOnClickListener {

            val model = UserModel("James")

            val myInt = model.multiply(3, 7)


//            val intent = Intent(this, SecondActivity::class.java)
//            intent.

            startActivity(Intent(
                this,
                SecondActivity::class.java
            ).apply {
                putExtra("string_val", "some string")
                putExtra("int_val", 1)
                putExtra("model", model) // parcelable object
            })

        }

        val mytext: TextView = findViewById(R.id.tv_text)

//        button.setOnClickListener {
//            startActivity(Intent(this, SecondActivity::class.java))
//        }

    }


    fun myFun(v: View) {
        Toast.makeText(this, "sdfghjk", Toast.LENGTH_SHORT).show()
    }

}