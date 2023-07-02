package com.example.homework3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.homework3.databinding.ItemAnimalBinding

class AnimalAdapter(
    private var list: List<Animal>,
    private val glide: RequestManager,
    private val onItemClick: (Animal) -> Unit,
) : RecyclerView.Adapter<AnimalItem>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimalItem = AnimalItem(
        binding = ItemAnimalBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        ),
        glide = glide,
        onItemClick = onItemClick,
    )

    override fun onBindViewHolder(holder: AnimalItem, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateDataset(newList: List<Animal>) {
        list = newList
        notifyDataSetChanged()
    }

}