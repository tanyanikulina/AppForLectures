package com.example.applectureone.presentation.other

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.applectureone.R
import com.example.applectureone.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    lateinit var binding: FragmentSecondBinding
    val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().getSharedPreferences("spref", Context.MODE_PRIVATE)

        // put your code here
        val tv = view.findViewById<TextView>(R.id.tvSecond)
        tv.text = args.mystr

    }
}