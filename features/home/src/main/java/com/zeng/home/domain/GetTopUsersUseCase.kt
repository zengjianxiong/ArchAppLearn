package com.zeng.home.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.zeng.model.Banner
import com.zeng.model.User
import com.zeng.repository.UsersRepository
import com.zeng.repository.utils.NetworkBoundResource
import com.zeng.repository.utils.Resource

class GetTopUsersUseCase(private val repository: UsersRepository) {
    suspend operator fun invoke(
        cachingStrategy: Int = NetworkBoundResource.LOAD_NO_CACHE
    ): LiveData<Resource<List<Banner.Item>>> {
        val map = HashMap<String, Any>()
        map.put("belong_id", 1);
        map.put("type", 4);
        return Transformations.map(repository.getBannerWithCache(cachingStrategy, map)) {
            it
        }
    }
}