package com.sakriya.replicaapp.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sakriya.replicaapp.R
import com.sakriya.replicaapp.userList
import model.Student

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var etFname : EditText
    private lateinit var etAge : EditText
    private lateinit var rgBtn: RadioGroup
    private lateinit var etAddress : EditText
    private lateinit var btnSave : Button
    var gender = "Male"



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
        rgBtn.setOnCheckedChangeListener { group, checkedId ->

            when(checkedId)
            {
                R.id.rbMale ->{
                    gender = "Male"
                }
                R.id.rbFemale->{
                    gender = "Female"
                }
                R.id.rbOthers ->{
                    gender = "Others"
                }
            }
        }

        btnSave.setOnClickListener {
            addUser()
        }
        return root
    }

    private fun addUser(){



            if (checkEmpty()){
                val User = Student("",etFname.text.toString(),etAge.text.toString().toInt(),gender, etAddress.text.toString() )
                userList.add(User)
                Toast.makeText(context,"Data is added",Toast.LENGTH_SHORT).show()
                //val intent = Intent()
                


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
                etAge.error = "Enter age"
                etAge.requestFocus()
                flag = false
            }
            TextUtils.isEmpty(etAddress.text) -> {
                etAddress.error = "Enter your address"
                etAddress.requestFocus()
                flag = false
            }

        }

        return flag
    }
}