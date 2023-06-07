package com.example.applectureone.presentation.permissions

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.applectureone.databinding.FragmentPermissionsBinding
import java.io.File

class PermissionsFragment : Fragment() {

    lateinit var binding: FragmentPermissionsBinding
    val fileName = "filename.txt"

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                Toast.makeText(requireContext(), "Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Denied", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPermissionsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPermissions.setOnClickListener { request() }

        with(binding) {

            btnSave.setOnClickListener {
                val text = et.text.toString()

                val file = File(requireActivity().getExternalFilesDir(null), fileName)
                file.writeText(text)

                Toast.makeText(requireContext(), "Saved", Toast.LENGTH_SHORT).show()
            }

            btnRead.setOnClickListener {
                val file = File(requireActivity().getExternalFilesDir(null), fileName)
                val text: String = file.readText()

                tv.text = text
                Toast.makeText(requireContext(), "Read", Toast.LENGTH_SHORT).show()
            }

        }

    }

    private fun request() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissionLauncher.launch(Manifest.permission.CAMERA)
        } else {
            Toast.makeText(requireContext(), "Already granted", Toast.LENGTH_SHORT).show()
        }
    }

}