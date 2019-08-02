package com.zeng.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.transition.ChangeBounds
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.zeng.common.base.BaseFragment
import com.zeng.common.base.BaseViewModel
import com.zeng.detail.databinding.DetailImageFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailImageFragment : BaseFragment() {

    private lateinit var binding: DetailImageFragmentBinding

    private val viewmodel: DetailImageViewModel by viewModel()

    private val args: DetailImageFragmentArgs by navArgs()

    override fun getViewModel(): BaseViewModel = viewmodel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        configureTransition()
        binding = DetailImageFragmentBinding.inflate(inflater, container, false)
        binding.viewmodel = viewmodel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel.loadDataWhenFragmentStarts(args.imageUrl)
    }

    private fun configureTransition() {
        val transition = ChangeBounds().apply {
            duration = 300
        }
        sharedElementEnterTransition = transition
        sharedElementReturnTransition = transition
    }
}
