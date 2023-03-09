package com.example.applectureone.presentation.articles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applectureone.databinding.ItemMytextBinding
import com.example.applectureone.domain.model.ArticleModel

class ArticleAdapter(
    val onClick: (model: ArticleModel, position: Int) -> Unit
) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    val list = ArrayList<ArticleModel>()

    fun setData(newList: List<ArticleModel>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = ItemMytextBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val currentElement = list[position]
        holder.bindItem(currentElement, position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ArticleViewHolder(val binding: ItemMytextBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItem(model: ArticleModel, position: Int) {
            binding.tvTitle.text = model.title
            binding.tvDesc.text = model.description

            binding.btn.setOnClickListener {
                onClick(model, position)
            }
        }

    }

}