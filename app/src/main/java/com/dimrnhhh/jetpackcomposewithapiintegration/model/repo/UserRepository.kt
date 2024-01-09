package com.dimrnhhh.jetpackcomposewithapiintegration.model.repo

import com.dimrnhhh.jetpackcomposewithapiintegration.model.data.User
import com.dimrnhhh.jetpackcomposewithapiintegration.model.service.RetrofitInstance

class UserRepository {
    private val userService = RetrofitInstance.userService

    suspend fun getUsers(): List<User> {
        return userService.getUsers()
    }
}