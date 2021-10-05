package com.example.displaydata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.displaydata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var todoList = mutableListOf<Todo>(
            Todo("Tarea 1", false),
            Todo("Tarea 2", true),
            Todo("Tarea 3", false),
            Todo("Tarea 4", false),
            Todo("Tarea 5", true),
            Todo("Tarea 6", false),
            Todo("Tarea 7", true),
            Todo("Tarea 8", false),
            Todo("Tarea 9", true),
            Todo("Tarea 10", false),
            Todo("Tarea 11", true)


            )

        //Initialize Adaptor
        val adapter = RvAdapter(todoList)
        binding.rvTodo.adapter = adapter
        binding.rvTodo.layoutManager = LinearLayoutManager(this)

        //Add new tasks
        binding.buttonAgregar.setOnClickListener{
            todoList.add(Todo(binding.editTextToDo.text.toString(), false))
            adapter.notifyItemInserted(todoList.size-1)

            Toast.makeText(this,"Tarea agregada",Toast.LENGTH_SHORT).show()
        }
    }
}