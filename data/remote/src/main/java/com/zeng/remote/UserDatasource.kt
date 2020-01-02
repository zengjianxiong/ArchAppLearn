package com.zeng.remote


import com.zeng.model.Banner
import com.zeng.model.BaseApiResult

class UserDatasource(private val apiService: ApiService) {
//   suspend fun fetchTopUsersAsync(): ApiResult<User> {
//        return apiService.fetchTopUsersAsync()
//    }

   suspend fun fetchBannerAsync(map: Map<String,Any>): BaseApiResult<Banner> {
        return  apiService.fetchUserDetailsAsync(map)
    }


}
