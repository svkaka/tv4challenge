package com.ovrbach.tv4challenge.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ovrbach.tv4challenge.R
import com.ovrbach.tv4challenge.data.stubs.Stubs
import com.ovrbach.tv4challenge.databinding.HomeFragmentBinding

//todo spacing category, show
//todo cateory,show title text appearance
//todo Show scrim background
//todo category all caps
//todo reconsider Ui - show rows instead of carousel

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    private var homeAdapter = HomeCategoryAdapter(RecyclerView.RecycledViewPool()) //todo prevent leakage

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        HomeFragmentBinding.bind(view).onViewBound()
    }

    private fun HomeFragmentBinding.onViewBound() {

        list.layoutManager = LinearLayoutManager(requireContext())
        list.adapter = homeAdapter
        homeAdapter.submitList(Stubs.categories)

    }
}