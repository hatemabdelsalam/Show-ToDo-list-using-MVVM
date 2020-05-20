package com.hatem.todolist.todo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hatem.todolist.utils.ConstantUtils
import com.hatem.todolist.databinding.FragmentToDoBinding
import com.hatem.todolist.todo.adapter.TodoAdapter
import com.hatem.todolist.todo.model.ToDoViewModel

/**
 * A simple [Fragment] subclass.
 */
class DoToFragment : Fragment() {

    lateinit var fragmentToDoBinding: FragmentToDoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentToDoBinding = FragmentToDoBinding.inflate(layoutInflater, container, false)

        return fragmentToDoBinding.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentToDoBinding.todoRv.layoutManager = LinearLayoutManager(requireContext())

        arguments?.getLong(ConstantUtils.EXTRA_USER_ID)?.let { getToDo(it) }

    }

    fun getToDo(userID: Long) {
        ToDoViewModel(userID).toDO.observe(requireActivity(), Observer { todoList ->
            fragmentToDoBinding.todoRv.adapter =
                TodoAdapter(todoList)
        })
    }

}
