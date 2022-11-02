package com.example.applectureone.presentation.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.applectureone.databinding.SettingsFragmentBinding

class SettingsFragment : Fragment() {

    private lateinit var viewModel: SettingsViewModel
    lateinit var binding: SettingsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SettingsFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(
            this, SettingsViewModelFactory(
                requireContext().applicationContext
            )
        ).get(SettingsViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            viewModel.saveUserName(binding.et.text.toString())
        }
        binding.btnRead.setOnClickListener {
            binding.tv.text = viewModel.getUserName()
        }


    }


}