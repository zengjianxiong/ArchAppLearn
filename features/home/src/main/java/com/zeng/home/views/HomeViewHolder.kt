package com.zeng.home.views

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.zeng.home.HomeViewModel
import com.zeng.home.databinding.ItemHomeBinding
import com.zeng.model.User

class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHomeBinding.bind(view)

    fun bindTo(user: User, viewModel: HomeViewModel) {
        binding.user = user;
        binding.viewmodel = viewModel
    }
}