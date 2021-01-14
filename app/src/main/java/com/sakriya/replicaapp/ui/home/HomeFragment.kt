package com.sakriya.replicaapp.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sakriya.replicaapp.R
import com.sakriya.replicaapp.userList
import model.Student
import model.StudentAdapter

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var recyclerView: RecyclerView



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_home, container, false)


        recyclerView = view.findViewById(R.id.recyclerView)


        loadActor()
        val adapter =StudentAdapter(userList, container!!.context)
        recyclerView.layoutManager =LinearLayoutManager(context)
        recyclerView.adapter = adapter


        return view
    }



    private fun loadActor(){
  userList.add(Student("https://cdn.business2community.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640.png"))
    }



}