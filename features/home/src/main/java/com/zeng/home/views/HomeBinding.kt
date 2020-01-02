package com.zeng.home.views

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zeng.model.Banner
import com.zeng.model.User
import com.zeng.repository.utils.Resource

object HomeBinding {

    @BindingAdapter("app:showWhenEmptyList")
    @JvmStatic
    fun showMessageErrorWhenEmptyList(view: View, resource: Resource<List<Banner.Item>>?) {
        if (resource != null) {
            view.visibility = if (resource.status == Resource.Status.ERROR
                && resource.data != null
                && resource.data!!.isEmpty()
            ) View.VISIBLE else View.GONE
        }
    }

    @BindingAdapter("app:showWhenLoading")
    @JvmStatic
    fun <T> showWhenLoading(view: SwipeRefreshLayout, resource: Resource<T>?) {
        Log.d(HomeBinding::class.java.simpleName, "Resource: $resource")
        if (resource != null) view.isRefreshing = resource.status == Resource.Status.LOADING
    }


    @BindingAdapter("app:imageUrl")
    @JvmStatic
    fun loadImage(view: ImageView, url: String) {
        Glide.with(view.context).load(url).apply(RequestOptions.centerCropTransform()).into(view)
    }


    @BindingAdapter("app:items")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, resource: Resource<List<User>>?) {
        with(recyclerView.adapter as HomeAdapter) {
            resource?.data?.let { updateData(it) }
        }
    }
}