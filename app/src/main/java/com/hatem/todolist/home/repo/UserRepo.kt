package com.hatem.todolist.home.repo

import com.hatem.todolist.network.RetrofitClient

class UserRepo {

    suspend fun getUser() = RetrofitClient.instant.getUsers()

}