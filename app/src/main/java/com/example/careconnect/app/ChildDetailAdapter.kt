package com.example.careconnect.app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.careconnect.data.Child
import com.example.careconnect.databinding.ListChildrenBinding

class ChildDetailAdapter: RecyclerView.Adapter<ChildDetailAdapter.ViewHolder>() {
    var childList: List<Child> = emptyList()
    fun updateData(newList: List<Child>) {
        childList = newList
    }

    class ViewHolder(private val listItem: ListChildrenBinding) : RecyclerView.ViewHolder(listItem.root){
        fun bind(item: Child){
            listItem.nameId.text = "Name: " + item.childName
            listItem.tvVaccines.text = item.age

//            item.age.forEach { child ->
//                listItem.tvVaccines.text = child
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(
            ListChildrenBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = childList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(childList[position])
    }
    }


