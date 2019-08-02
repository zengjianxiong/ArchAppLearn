package com.zeng.detail


import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.navArgs

import com.zeng.common.base.BaseFragment
import com.zeng.common.base.BaseViewModel
import com.zeng.detail.databinding.DetailFragmentBinding

import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailFragment : BaseFragment() {

    private val viewModel: DetailViewModel by viewModel()
    private lateinit var binding: DetailFragmentBinding


    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DetailFragmentBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.loadDataWhenActivityStarts(args.login)


    }

    override fun getViewModel(): BaseViewModel = viewModel


    override fun getExtras(): FragmentNavigator.Extras =
        FragmentNavigatorExtras(binding.fragmentDetailAvatar to getString(R.string.transition_avatar_dest))


}
