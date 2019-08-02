package com.zeng.repository

import androidx.lifecycle.LiveData
import com.zeng.local.dao.UserDao
import com.zeng.model.ApiResult
import com.zeng.model.User
import com.zeng.remote.UserDatasource
import com.zeng.repository.utils.NetworkBoundResource
import com.zeng.repository.utils.Resource

interface UsersRepository {
    suspend fun getTopUsersWithCache(forceRefresh: Boolean = false): LiveData<Resource<List<User>>>

    suspend fun getUserDetailWithCache(forceRefresh: Boolean = false, login: String): LiveData<Resource<User>>
}


class UsersRepositoryImpl(private val userDao: UserDao, private val datasource: UserDatasource) :
    UsersRepository {
    override suspend fun getUserDetailWithCache(forceRefresh: Boolean, login: String): LiveData<Resource<User>> {

        return object : NetworkBoundResource<User, User>() {

            override fun processResponse(response: User): User
                    = response

            override suspend fun saveCallResults(items: User)
                    = userDao.save(items)

            override fun shouldFetch(data: User?): Boolean
                    = data == null
                    || data.haveToRefreshFromNetwork()
                    || data.name.isNullOrEmpty()
                    || forceRefresh

            override suspend fun loadFromDb(): User
                    = userDao.getUser(login)

            override suspend fun createCallAsync(): User
                    = datasource.fetchUserDetailsAsync(login)

        }.build().asLiveData()
    }

    override suspend fun getTopUsersWithCache(forceRefresh: Boolean): LiveData<Resource<List<User>>> {
        return object : NetworkBoundResource<List<User>, ApiResult<User>>() {
            override fun processResponse(response: ApiResult<User>) = response.items

            override suspend fun saveCallResults(items: List<User>) = userDao.save(items)

            override fun shouldFetch(data: List<User>?)
                    = data == null || data.isEmpty() || forceRefresh

            override suspend fun loadFromDb(): List<User> = userDao.getTopUsers()

            override suspend fun createCallAsync(): ApiResult<User> {

                return  datasource.fetchTopUsersAsync()
            }

        }.build().asLiveData()
    }

}