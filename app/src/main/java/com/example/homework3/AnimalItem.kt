package com.example.homework3

import android.content.Context
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.homework3.databinding.ItemAnimalBinding

class AnimalItem(
    private val binding:ItemAnimalBinding,
    private val glide: RequestManager,
    private val onItemClick: (Animal) -> Unit,
    ) : ViewHolder(binding.root) {

    private val options: RequestOptions = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.NONE)

    fun onBind(animal: Animal) {
        binding.run {
            tvTitle.text = animal.name
            tvDesc.text = animal.description

            glide
                .load(animal.url)
                .placeholder(R.drawable.cat)
                .apply(options)
                .into(ivImage)

            root.setOnClickListener {
                onItemClick(animal)
            }

        }
    }
}