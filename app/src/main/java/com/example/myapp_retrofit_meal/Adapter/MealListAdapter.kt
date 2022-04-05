package com.example.myapp_retrofit_meal.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp_retrofit_meal.Model.Meal
import com.example.myapp_retrofit_meal.R
import com.squareup.picasso.Picasso

class MealListAdapter (var context: Context, var mealModelList: MutableList<Meal>)
    : RecyclerView.Adapter<MealListAdapter.Myviewmodel>(){
    inner class Myviewmodel(itemView: View): RecyclerView.ViewHolder(itemView){

        var imgMovie: ImageView//StrImage
        var txtTittle: TextView//name
        var txttype: TextView//Description

        init {
            imgMovie=itemView.findViewById(R.id.imgMoviePoster)
            txtTittle=itemView.findViewById(R.id.mealTitle)
            txttype=itemView.findViewById(R.id.txtType)

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewmodel {
        return Myviewmodel(LayoutInflater.from(context).inflate(R.layout.layout_meal_list_xml,parent,false))

    }
    override fun onBindViewHolder(holder: Myviewmodel, position: Int) {
        Picasso.get().load(mealModelList[position].strMealThumb).into(holder.imgMovie)
        holder.txtTittle.text =mealModelList[position].strMeal
        holder.txttype.text=mealModelList[position].strCategory
    }

    override fun getItemCount(): Int {
        return mealModelList.size
    }
}