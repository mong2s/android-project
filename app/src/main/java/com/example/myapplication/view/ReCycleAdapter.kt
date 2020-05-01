package com.example.myapplication.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.data.GitData
import kotlinx.android.synthetic.main.gitdata_recycleview_items.view.*

class ReCycleAdapter(val context: Context, val gitDataList: ArrayList<GitData>):
    RecyclerView.Adapter<ReCycleAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.gitdata_recycleview_items, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return gitDataList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(gitDataList[position], context)
    }


    // use image loading lib - glide 4.11.0
    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val gitDataTitle = itemView?.findViewById<TextView>(R.id.GitDataTitle)
        val gitDataValue = itemView?.findViewById<TextView>(R.id.GitDataValue)

        fun bind (gitData: GitData, context: Context) {
            if (gitData.gitImage == "") {
                val resourceId = context.resources.getIdentifier(gitData.gitImage, "drawable", context.packageName)
                Glide.with(context).load(resourceId).into(itemView.GitDataTestImage)
            } else {
                Glide.with(context).load(R.mipmap.ic_launcher).into(itemView.GitDataTestImage)
            }
            gitDataTitle?.text = gitData.gitTitle
            gitDataValue?.text = gitData.gitValue

        }
    }


}