package com.hatem.todolist.todo.model

import androidx.lifecycle.liveData
import com.hatem.todolist.todo.repo.ToDoRepo
import kotlinx.coroutines.Dispatchers

class ToDoViewModel(val userId:Long) {

    val toDO = liveData (Dispatchers.IO) {
        val toDo = ToDoRepo().getToDo(userId)

        emit(toDo)
    }
}