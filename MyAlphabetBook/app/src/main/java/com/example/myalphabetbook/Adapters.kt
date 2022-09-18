package com.example.myalphabetbook

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.makeramen.roundedimageview.RoundedImageView

class Adapters(val context:Context):RecyclerView.Adapter<Adapters.MyViewHolder>() {
    lateinit var list:List<Bitmap>
    fun setContentList(list:List<Bitmap>){
        this.list=list
        notifyDataSetChanged()
    }
    inner class MyViewHolder(view:View):RecyclerView.ViewHolder(view){
var image=itemView.findViewById<RoundedImageView>(R.id.list_item_image)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapters.MyViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.list_image,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Adapters.MyViewHolder, position: Int) {
   holder.image.setImageBitmap(list[position])
    }
}