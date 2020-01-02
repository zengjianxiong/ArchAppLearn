package com.zeng.remote


import com.zeng.model.Banner
import com.zeng.model.BaseApiResult
import com.zeng.model.User

import retrofit2.http.*

interface ApiService {
//    @GET("search/users")
//    suspend fun fetchTopUsersAsync(
//        @Query("q") query: String = "PhilippeB",
//        @Query("sort") sort: String = "followers"
//    ): ApiResult<User>


    @POST("banner/list")
    @JvmSuppressWildcards
    suspend fun fetchUserDetailsAsync(@QueryMap map: Map<String, Any>): BaseApiResult<Banner>

}
