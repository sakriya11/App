package model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sakriya.replicaapp.R


class StudentAdapter(val lstStudent : ArrayList<Student>, val context : Context) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(view:View) : RecyclerView.ViewHolder(view){

        val imageView : ImageView
        val tvName : TextView
        val tvAge : TextView
        val tvAddress : TextView
        val tvGender : TextView
        val ivDelete : ImageView

        init{
            imageView = view.findViewById(R.id.imageView)
            tvName = view.findViewById(R.id.tvName)
            tvAge= view.findViewById(R.id.tvAge)
            tvAddress = view.findViewById(R.id.tvAddress)
            tvGender = view.findViewById(R.id.tvGender)
            ivDelete = view.findViewById(R.id.delete)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAdapter.StudentViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.student_layout,parent,false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentAdapter.StudentViewHolder, position: Int) {

        val student = lstStudent[position]

        holder.tvName.text = student.studentName
        holder.tvAge.text = student.studentAge.toString()
        holder.tvAddress.text = student.studentAddress
        holder.tvGender.text = student.studentGender


        Glide.with(context).load(student.studentImage).into(holder.imageView)

        holder.ivDelete.setOnClickListener {
            lstStudent.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {

        return lstStudent.size
    }
}