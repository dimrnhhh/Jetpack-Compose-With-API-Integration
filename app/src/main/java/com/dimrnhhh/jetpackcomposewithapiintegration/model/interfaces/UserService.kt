package com.dimrnhhh.jetpackcomposewithapiintegration.model.interfaces

import com.dimrnhhh.jetpackcomposewithapiintegration.model.data.User
import retrofit2.http.GET

interface UserService {
    @GET("users")
    suspend fun getUsers(): List<User>
}