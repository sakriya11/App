package com.sakriya.replicaapp.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sakriya.replicaapp.R

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var etFname : EditText
    private lateinit var etAge : EditText
    private lateinit var rgBtn: RadioGroup
    private lateinit var etAddress : EditText
    private lateinit var btnSave : Button

    var userList: ArrayList<NewUser> = arrayListOf()


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        etFname = root.findViewById(R.id.etFname)
        etAge = root.findViewById(R.id.etAge)
        rgBtn = root.findViewById(R.id.rgBtn)
        etAddress = root.findViewById(R.id.etAddress)
        btnSave = root.findViewById(R.id.btnSave)

        return root
    }

    private fun addUser(){

        btnSave.setOnClickListener {

            if (checkEmpty()){
                val User = NewUser(etFname.text.toString(),etAge.text.toString().toInt(),rgBtn., etAddress.text.toString() )
                userList.add(User)
                val intent = Intent()
                


            }


        }


    }

    private fun checkEmpty(): Boolean{

        var flag = true

        when {
            TextUtils.isEmpty(etFname.text) -> {
                etFname.error = "Enter your name"
                etFname.requestFocus()
                flag = false
            }
            TextUtils.isEmpty(etAge.text) -> {
                etAge.error = "Enter your first name"
                etAge.requestFocus()
                flag = false
            }
            TextUtils.isEmpty(etAddress.text) -> {
                etAddress.error = "Enter your last name"
                etAddress.requestFocus()
                flag = false
            }

        }

        return flag
    }
}