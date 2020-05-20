package com.hatem.todolist.home.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hatem.todolist.databinding.FragmentHomeBinding
import com.hatem.todolist.home.adapter.UsersAdapter
import com.hatem.todolist.home.model.UsersViewModel

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var homeBinding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeBinding=FragmentHomeBinding.inflate(layoutInflater,container,false)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeBinding.usersRv.layoutManager = LinearLayoutManager(requireContext())

        getUsers()
    }

    private fun getUsers(){

        UsersViewModel().users.observe(requireActivity(), Observer { userData-> homeBinding.usersRv.adapter = UsersAdapter(this, userData) })
    }
}
