package com.hatem.todolist.home.model

import androidx.lifecycle.liveData
import com.hatem.todolist.home.repo.UserRepo
import kotlinx.coroutines.Dispatchers

class UsersViewModel() {

    val users = liveData(Dispatchers.IO) {
        val userDate = UserRepo().getUser()

        emit(userDate)
    }

}