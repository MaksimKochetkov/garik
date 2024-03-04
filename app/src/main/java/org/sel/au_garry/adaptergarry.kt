package org.sel.au_garry

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class adaptergarry(val con: Context, val data: List<chardata>): RecyclerView.Adapter<adaptergarry.link>() {
    class link(vi: View):RecyclerView.ViewHolder(vi) {
        val imageiv: ImageView = vi.findViewById(R.id.imageView)
        val nametv: TextView = vi.findViewById(R.id.textViewName)
        val fakul: TextView = vi.findViewById(R.id.textViewFakul)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): link {
        val list = LayoutInflater.from(con).inflate(R.layout.card,parent,false)
        return link(list)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: link, position: Int) {
        Glide.with(con).load(data[position].image).into(holder.imageiv)
        holder.nametv.text = data[position].character
        holder.fakul.text = data[position].hogwartsHouse
    }
}