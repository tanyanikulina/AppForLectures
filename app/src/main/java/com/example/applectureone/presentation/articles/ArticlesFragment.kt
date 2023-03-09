package com.example.applectureone.presentation.articles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.applectureone.databinding.FragmentArticlesBinding

class ArticlesFragment : Fragment() {

    lateinit var binding: FragmentArticlesBinding
    lateinit var adapter: ArticleAdapter

    val vm by activityViewModels<ArticlesViewModel>()

    val viewModel by lazy {
        ViewModelProvider(
            this, ArticlesViewModelFactory(
                requireContext().applicationContext
            )
        )[ArticlesViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        viewModel = ViewModelProvider(
//            this, ArticlesViewModelFactory(
//                requireContext().applicationContext
//            )
//        ).get(ArticlesViewModel::class.java)

        binding = FragmentArticlesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ArticleAdapter { model, position ->

            findNavController().navigate(ArticlesFragmentDirections.toSecondFragment("vbn", model))

//            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

        binding.rv.adapter = adapter
        binding.btnGoToSettings.setOnClickListener {
            findNavController().navigate(ArticlesFragmentDirections.toSettingsFragment())
//            findNavController().navigate(ArticlesFragmentDirections.toSecondFragment("some agrument"))
        }
        binding.btnGoToPermissions.setOnClickListener {
            findNavController().navigate(ArticlesFragmentDirections.toPermissions())
        }

        binding.swipe.setOnRefreshListener {
            viewModel.reloadData()
//            binding.swipe.isRefreshing = false
        }

        viewModel.articles.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
        viewModel.weather.observe(viewLifecycleOwner) {
            binding.tvWeather.text = it
        }

        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.rv.isVisible = !it
            if (!it)
                binding.swipe.isRefreshing = it
//            binding.pb.isVisible = it
        }


    }
}