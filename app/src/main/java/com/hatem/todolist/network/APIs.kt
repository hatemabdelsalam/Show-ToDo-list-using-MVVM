package com.hatem.todolist.network

import com.hatem.todolist.home.model.UserDTO
import com.hatem.todolist.todo.model.ToDoDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface APIs {

    @GET(Urls.USERS)
    suspend fun getUsers(): List<UserDTO>

    @GET(Urls.USERS+"/{id}/"+Urls.TODO)
    suspend fun getToDO(@Path("id") userId:Long):List<ToDoDTO>

}