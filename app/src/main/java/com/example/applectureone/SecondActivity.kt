package com.example.applectureone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.applectureone.databinding.ActivitySecondBinding
import com.example.applectureone.presentation.other.MyActionInterface
import com.example.applectureone.presentation.other.ThirdFragment

class SecondActivity : AppCompatActivity(), MyActionInterface {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(binding.fragment.id, ThirdFragment()) // place where to put fragment
            .addToBackStack(null) // we want add fragment to backStack
            .commit() // commit transaction

        val myInt = intent.getIntExtra("int_val", -1)
        val myStr = intent.getStringExtra("string_val")

        binding.editText.setText(myStr)


    }

    override fun myFun() {


    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        outState.run {
//            putString("saved_text", binding.editText.text.toString())
//        }
//        super.onSaveInstanceState(outState)
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        savedInstanceState.run {
//            val text = getString("saved_text")
//            binding.editText.setText(text)
//        }
//    }

}