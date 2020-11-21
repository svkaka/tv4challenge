package com.ovrbach.tv4challenge.feature.home

import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ovrbach.tv4challenge.R
import com.ovrbach.tv4challenge.app.core.BaseViewFragment
import com.ovrbach.tv4challenge.databinding.HomeFragmentBinding
import com.ovrbach.tv4challenge.logic.LoadShowsUseCase
import com.ovrbach.tv4challenge.util.LinearSpacingItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseViewFragment<HomeFragmentBinding>(R.layout.home_fragment) {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val viewModel: HomeViewModel by viewModels()
    private var homeAdapter = HomeShowAdapter() //todo prevent leakage

    override fun bindView(view: View): HomeFragmentBinding = HomeFragmentBinding.bind(view)

    override fun HomeFragmentBinding.onViewCreated() {
        list.layoutManager = LinearLayoutManager(requireContext())
        list.addItemDecoration(
            LinearSpacingItemDecoration(resources.getDimensionPixelSize(R.dimen.margin_medium))
        )
        list.adapter = homeAdapter

        viewModel.state.observe(viewLifecycleOwner, { state ->
            when (state) {
                is LoadShowsUseCase.State.Failed -> buildErrorSnackbar(
                    state.throwable.message!!,
                    "Retry"
                ) { viewModel.reloadShows() }
                is LoadShowsUseCase.State.Success -> homeAdapter.submitList(state.shows)
            }
        })

        viewModel.isLoading.observe(viewLifecycleOwner, { isLoading ->
            refreshLayout.isRefreshing = isLoading
        })

        refreshLayout.setOnRefreshListener {
            viewModel.reloadShows()
        }
    }
}