package com.hatem.todolist.todo.repo

import com.hatem.todolist.network.RetrofitClient

class ToDoRepo {
    suspend fun getToDo(userId:Long)=RetrofitClient.instant.getToDO(userId)
}