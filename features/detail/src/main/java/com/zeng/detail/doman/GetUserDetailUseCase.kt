package com.zeng.detail.doman

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations

import com.zeng.model.User
import com.zeng.repository.UsersRepository
import com.zeng.repository.utils.Resource

class GetUserDetailUseCase(private val repository: UsersRepository) {
    suspend operator fun invoke(forceRefresh: Boolean = false, login: String): LiveData<Resource<User>> {
        return Transformations.map(repository.getUserDetailWithCache(forceRefresh, login)) {
            it
        }
    }

}