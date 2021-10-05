package com.example.displaydata

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.displaydata.databinding.ItemTodoBinding

//Handles Recycler View

class RvAdapter(var todos:List<Todo>) : RecyclerView.Adapter<RvAdapter.ViewHolder>()
{
    class ViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTodoBinding.inflate(layoutInflater,parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RvAdapter.ViewHolder, position: Int) {

        //holder.binding.apply {  } -> If we don't want to write it many times
        holder.binding.textView.text = todos[position].title
        holder.binding.checkBoxState.isChecked = todos[position].isChecked
    }

    override fun getItemCount(): Int {
        return todos.size
    }

}