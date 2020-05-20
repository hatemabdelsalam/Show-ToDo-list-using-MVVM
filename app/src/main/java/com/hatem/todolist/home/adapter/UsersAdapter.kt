package com.hatem.todolist.home.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.hatem.todolist.utils.ConstantUtils
import com.hatem.todolist.R
import com.hatem.todolist.databinding.RowUserBinding
import com.hatem.todolist.home.model.UserDTO

class UsersAdapter(val context: Fragment, private val userList:List<UserDTO>) : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowUserBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.rowUserBinding.user = userList[position]

        holder.rowUserBinding.root.setOnClickListener(View.OnClickListener {

            var bundle = Bundle()
            bundle.putLong(ConstantUtils.EXTRA_USER_ID, userList[position].id!!)

            context.findNavController().navigate(R.id.action_homeFragment_to_doToFragment,bundle)
        })
    }

    class ViewHolder(var rowUserBinding: RowUserBinding) : RecyclerView.ViewHolder(rowUserBinding.root){

    }

}