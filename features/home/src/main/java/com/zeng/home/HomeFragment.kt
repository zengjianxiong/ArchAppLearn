package com.zeng.home


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.zeng.common.base.BaseFragment
import com.zeng.common.base.BaseViewModel
import com.zeng.home.databinding.HomeFragmentBinding
import com.zeng.home.views.HomeAdapter

import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment() {


    private val TAG=HomeFragment::class.java.name
    private val viewModel: HomeViewModel by viewModel()
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = HomeFragmentBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun getViewModel(): BaseViewModel = viewModel


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configureRecyclerView()

        viewModel.users.observe(viewLifecycleOwner, Observer {
            it?.data?.let {list->
                for(item in list){
                    Log.d(TAG,item.toString())
                }
            }
        })
    }

    private fun configureRecyclerView() {

        binding.fragmentHomeRv.adapter = HomeAdapter(viewModel)
    }
}
