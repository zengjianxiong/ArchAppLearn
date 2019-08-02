package com.zeng.remote

import com.zeng.model.ApiResult
import com.zeng.model.User
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("search/users")
    suspend fun fetchTopUsersAsync(
        @Query("q") query: String = "PhilippeB",
        @Query("sort") sort: String = "followers"
    ): ApiResult<User>


    @GET("users/{login}")
    suspend fun fetchUserDetailsAsync(@Path("login") login: String): User

}
