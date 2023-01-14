package com.example.gameofthrones_retrofit

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gameofthrones_retrofit.models.Hero

class HeroAdapter (private val baseContext: Context, private val heroList: MutableList<Hero>): RecyclerView.Adapter<HeroAdapter.HeroHolder>() {
    class HeroHolder(itemView: View): RecyclerView.ViewHolder(itemView)  {
        var name: TextView = itemView.findViewById(R.id.tv_name)
        var culture: TextView = itemView.findViewById(R.id.tv_culture)
        var born : TextView = itemView.findViewById(R.id.tv_born)
        var titles: TextView = itemView.findViewById(R.id.tv_titles)
        var aliases: TextView = itemView.findViewById(R.id.tv_aliases)
        var playedBy: TextView = itemView.findViewById(R.id.tv_playedBy)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return HeroHolder(itemView)
    }
    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.setIsRecyclable(false)
        holder.name.text = heroList.get(position).name
        holder.culture.text = heroList.get(position).culture
        holder.born.text = heroList.get(position).born
        holder.titles.text = heroList.get(position).titles.toString()
        holder.aliases.text = heroList.get(position).aliases.toString()
        holder.playedBy.text = heroList.get(position).playedBy.toString()

        println(heroList.get(position).name)
        println(heroList.get(position).culture)
        println(heroList.get(position).born)
        println(heroList.get(position).titles)
        println(heroList.get(position).aliases)
        println(heroList.get(position).playedBy)
    }
    override fun getItemCount() = heroList.size
}