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
        viewModel = ViewModelProvider(
            this, SettingsViewModelFactory(
                requireContext().applicationContext
            )
        ).get(SettingsViewModel::class.java)
        binding = SettingsFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnSave.setOnClickListener {
                viewModel.saveUserName(et.text.toString())
            }
            btnRead.setOnClickListener {
                tv.text = viewModel.getUserName()
            }

            btnSaveToDb.setOnClickListener {
                val first = etFirst.text.toString()
                val last = etLast.text.toString()
                viewModel.saveToDb(first, last)

            }
            btnReadFromDb.setOnClickListener {
                viewModel.readFromDb()
            }
            viewModel.userDataList.observe(viewLifecycleOwner) {
                tvDb.text = it.toString()
            }

        }

    }


}