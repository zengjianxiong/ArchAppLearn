package com.zeng.remote


import com.zeng.model.ApiResult
import com.zeng.model.User

class UserDatasource(private val apiService: ApiService) {
   suspend fun fetchTopUsersAsync(): ApiResult<User> {
        return apiService.fetchTopUsersAsync()
    }

   suspend fun fetchUserDetailsAsync(login: String): User {
        return  apiService.fetchUserDetailsAsync(login)
    }


}
