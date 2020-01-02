package com.zeng.repository

import androidx.lifecycle.LiveData
import com.zeng.local.dao.BannerDao

import com.zeng.model.Banner
import com.zeng.model.BaseApiResult

import com.zeng.remote.UserDatasource
import com.zeng.repository.utils.NetworkBoundResource
import com.zeng.repository.utils.Resource


interface UsersRepository {
    suspend fun getBannerWithCache(
        cachingStrategy: Int = NetworkBoundResource.LOAD_NO_CACHE,
        map: Map<String, Any>
    ): LiveData<Resource<List<Banner.Item>>>
}


class UsersRepositoryImpl(
    private val bannerDao: BannerDao,
    private val datasource: UserDatasource
) :
    UsersRepository {
    override suspend fun getBannerWithCache(
        cachingStrategy: Int,
        map: Map<String, Any>
    ): LiveData<Resource<List<Banner.Item>>> {
        return object : NetworkBoundResource<List<Banner.Item>, BaseApiResult<Banner>>() {

            override fun processResponse(response: BaseApiResult<Banner>) =
                response.data.list

            override suspend fun saveCallResults(items: List<Banner.Item>) =
                bannerDao.save(items)

            override fun shouldFetch(data: List<Banner.Item>?) =
                data == null || data.isEmpty()

            override suspend fun loadFromDb(): List<Banner.Item>? = bannerDao.getBanners()

            override suspend fun createCallAsync(): BaseApiResult<Banner> {

                return datasource.fetchBannerAsync(map)
            }

            override fun cachingStrategy(): Int = cachingStrategy

        }.build().asLiveData()
    }

}