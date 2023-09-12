package com.example.xenoblade3

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xenoblade3.databinding.ItemRowCharacterBinding

class ListCharaAdapter(private val listChara: ArrayList<Character>):
    RecyclerView.Adapter<ListCharaAdapter.ListViewHolder>() {

    class ListViewHolder(internal var binding: ItemRowCharacterBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(ItemRowCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return listChara.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, gender, faction, role, vaEn, vaJp, photo) = listChara[position]
        holder.binding.imgItemChara.setImageResource(photo)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_character", listChara[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }
}