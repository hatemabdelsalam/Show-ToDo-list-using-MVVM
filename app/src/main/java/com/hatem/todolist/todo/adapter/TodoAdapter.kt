package com.hatem.todolist.todo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hatem.todolist.databinding.RowTodoBinding
import com.hatem.todolist.todo.model.ToDoDTO

class TodoAdapter(val toDoList: List<ToDoDTO>) : RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    class ViewHolder(var rowTodoBinding: RowTodoBinding) : RecyclerView.ViewHolder(rowTodoBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rowTodoBinding = RowTodoBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(
            rowTodoBinding
        )
    }

    override fun getItemCount(): Int {
        return toDoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.rowTodoBinding.todo = toDoList[position]
    }
}