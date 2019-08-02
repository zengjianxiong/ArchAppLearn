package com.zeng.home.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zeng.home.HomeViewModel
import com.zeng.home.R
import com.zeng.model.User

class HomeAdapter(private val viewModel: HomeViewModel) : RecyclerView.Adapter<HomeViewHolder>() {

    private var users: MutableList<User> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false))

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bindTo(users[position], viewModel)
    }


    fun updateData(items: List<User>) {
        val diffCallback = HomeItemDiffCallback(users, items)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        users.clear()
        users.addAll(items)
        diffResult.dispatchUpdatesTo(this)
    }

}