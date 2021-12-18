package com.example.rssfeed.Resource

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rssfeed.Model.Question
import com.example.rssfeed.databinding.ItemRowBinding


class RVAdapter(val result: MutableList<Question>?) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    class ViewHolder (val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val question = result!![position]

        holder.binding.apply {
            tvTitle.text = "َQuestion: ${question.title}"
            tvName.text = "By: ${question.name}"
            cardView.setOnClickListener {
                holder.itemView.context.startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse(question.questionLink)))
            }
        }
    }

    override fun getItemCount(): Int = result!!.size

}