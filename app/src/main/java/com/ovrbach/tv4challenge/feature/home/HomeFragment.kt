package com.ovrbach.tv4challenge.feature.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ovrbach.tv4challenge.R
import com.ovrbach.tv4challenge.databinding.HomeFragmentBinding
import com.ovrbach.tv4challenge.util.LinearSpacingItemDecoration
import dagger.hilt.android.AndroidEntryPoint

//todo spacing category, show
//todo cateory,show title text appearance
//todo Show scrim background
//todo category all caps

@AndroidEntryPoint
class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val viewModel: HomeViewModel by viewModels()
    private var homeAdapter = HomeShowAdapter() //todo prevent leakage

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        HomeFragmentBinding.bind(view).onViewBound()
    }

    private fun HomeFragmentBinding.onViewBound() {
        list.layoutManager = LinearLayoutManager(requireContext())
        list.addItemDecoration(LinearSpacingItemDecoration(84)) //todo use dimens
        list.adapter = homeAdapter

        viewModel.shows.observe(viewLifecycleOwner, { shows ->
            homeAdapter.submitList(shows)
        })

    }
}