package com.example.applectureone.presentation.other

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applectureone.databinding.ItemMytextBinding
import com.example.applectureone.domain.model.ArticleModel

class SomeAdapter(
    val onClick: (model: ArticleModel, position: Int) -> Unit
) : RecyclerView.Adapter<SomeAdapter.SomeViewHolder>() {

    private var list = ArrayList<ArticleModel>()
        set(value) {
            field.clear()
            field.addAll(value)
            notifyDataSetChanged()
        }

    inner class SomeViewHolder(val binding: ItemMytextBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItem(model: ArticleModel, position: Int) {
            binding.tvTitle.text = model.title
            binding.tvDesc.text = model.description

//            Glide.with(binding.iv.context)
//                .load("https://i.imgur.com/AxETlhd.jpg")
//                .centerInside()
//                .placeholder(R.drawable.cat)
//                .into(binding.iv)

            binding.btn.setOnClickListener {
                onClick(model, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SomeViewHolder {
        val view = ItemMytextBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SomeViewHolder, position: Int) {
        val currentElement = list[position]
        holder.bindItem(currentElement, position)
    }

}