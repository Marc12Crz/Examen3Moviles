package com.marcelo.cristhian.laboratoriocalificado03.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marcelo.cristhian.laboratoriocalificado03.databinding.ItemTeacherBinding
import com.marcelo.cristhian.laboratoriocalificado03.model.Teacher

class TeacherAdapter(
    private val teachers: List<Teacher>,
    private val onItemClick: (Teacher) -> Unit,
    private val onItemLongClick: (Teacher) -> Unit
) : RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder>() {

    inner class TeacherViewHolder(val binding: ItemTeacherBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val binding = ItemTeacherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeacherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        val teacher = teachers[position]
        with(holder.binding) {
            textViewName.text = teacher.name
            textViewLastName.text = teacher.last_name
            Glide.with(imageView.context).load(teacher.imageUrl).into(imageView)
            root.setOnClickListener { onItemClick(teacher) }
            root.setOnLongClickListener {
                onItemLongClick(teacher)
                true
            }
        }
    }

    override fun getItemCount(): Int = teachers.size
}
