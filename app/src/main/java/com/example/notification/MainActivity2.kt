package com.example.notification

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#146775")))


//        Todo Logic

        todoAdapter = TodoAdapter(mutableListOf())

        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val todoTitle = etTodoTitle.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }
        btnDeleteDoneTodos.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }

        toolbar.setNavigationOnClickListener{
            Toast(this).showCustomToast ("Hello! This is TODO!", this)
        }
 //        setSupportActionBar(tool)

    }
  override fun onCreateOptionsMenu(menu: Menu?):Boolean{
      menuInflater.inflate(R.menu.mainmenu,menu)
      return true
   }

    override fun onOptionsItemSelected(item: MenuItem):Boolean{
        var itemview=item.itemId
        when(itemview){
            R.id.add->Toast.makeText(applicationContext,"Add Clicked", Toast.LENGTH_SHORT).show()
            R.id.notify->Toast.makeText(applicationContext,"Notification Clicked", Toast.LENGTH_SHORT).show()
        }
           return false
    }
}