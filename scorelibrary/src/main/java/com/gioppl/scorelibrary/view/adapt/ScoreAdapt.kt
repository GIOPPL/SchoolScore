package com.gioppl.scorelibrary.view.adapt

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.gioppl.scorelibrary.R
import com.gioppl.scorelibrary.model.entity.ScoreEntity

/**
 * Created by GIOPPL on 2017/8/16.
 */
class ScoreAdapt(private var mList:ArrayList<ScoreEntity>) : RecyclerView.Adapter<ScoreAdapt.ScoreViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ScoreViewHolder
        =ScoreViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.score_item,parent,false))

    override fun onBindViewHolder(holder: ScoreViewHolder?, position: Int) {
        holder!!.tv_item!!.text=mList[position].courseName+","+mList[position].score
    }

    override fun getItemCount(): Int=mList.size

    class ScoreViewHolder (item:View):RecyclerView.ViewHolder(item){
        var tv_item:TextView?=null
        init {
            tv_item= item.findViewById(R.id.tv_item) as TextView?
        }
    }
}