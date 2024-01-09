package com.dimrnhhh.jetpackcomposewithapiintegration.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dimrnhhh.jetpackcomposewithapiintegration.model.data.User
import com.dimrnhhh.jetpackcomposewithapiintegration.model.repo.UserRepository
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    private val repository = UserRepository()
    private val _users = MutableLiveData<List<User>>()

    val users: LiveData<List<User>> = _users

    fun fetchUsers() {
        viewModelScope.launch {
            try {
                val users = repository.getUsers()
                _users.value = users
            } catch (e: Exception) {

            }
        }
    }
}