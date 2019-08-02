package com.zeng.home.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.zeng.model.User
import com.zeng.repository.UsersRepository
import com.zeng.repository.utils.Resource

class GetTopUsersUseCase(private val repository: UsersRepository) {
    suspend operator fun invoke(forceRefresh: Boolean = false): LiveData<Resource<List<User>>> {
        return Transformations.map(repository.getTopUsersWithCache(forceRefresh)) {
            it
        }
    }
}