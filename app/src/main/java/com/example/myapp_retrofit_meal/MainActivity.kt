package com.example.myapp_retrofit_meal

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp_retrofit_meal.Adapter.MealListAdapter
import com.example.myapp_retrofit_meal.ViewModel.MainActivityViewModel
import dmax.dialog.SpotsDialog

class MainActivity : AppCompatActivity() {

    var mainactivityViewModel:MainActivityViewModel?=null
    var recyclerView: RecyclerView?=null
    var adapter: MealListAdapter?=null
    var layoutManager: LinearLayoutManager?=null
    var dialog: AlertDialog?=null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainactivityViewModel= ViewModelProvider(this)[MainActivityViewModel::class.java]

        dialog= SpotsDialog.Builder().setCancelable(false).setContext(this).build()
        dialog!!.show()

        recyclerView =findViewById(R.id.recyclerview)
        recyclerView!!.setHasFixedSize(true)
        layoutManager= LinearLayoutManager(this)
        recyclerView!!.layoutManager=layoutManager


        mainactivityViewModel!!.getMealList.observe(this){ movieModels ->
            Log.e("MainActivity","MovieList"+movieModels)
            if(movieModels!= null){
                adapter = movieModels.meals?.let { MealListAdapter(this, it) }
                adapter!!.notifyDataSetChanged()
                recyclerView!!.adapter=adapter
                dialog!!.dismiss()
            }
        }
    }
}