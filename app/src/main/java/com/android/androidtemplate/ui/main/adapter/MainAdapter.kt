package com.android.androidtemplate.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.androidtemplate.R
import com.android.androidtemplate.data.model.User
import com.android.androidtemplate.interfaces.AdapterItemClick
import com.bumptech.glide.Glide

/**
 * @Author: Abdul Rehman
 * @Date: 20/04/2022.
 */

class MainAdapter(
    private val users: ArrayList<User>,
    val itemClickListener: AdapterItemClick<User>
) :
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    inner class DataViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            val textViewUserName = itemView.findViewById(R.id.textViewUserName) as TextView
            val textViewUserEmail = itemView.findViewById(R.id.textViewUserEmail) as TextView
            val imageViewAvatar = itemView.findViewById(R.id.imageViewAvatar) as ImageView

            textViewUserName.text = user.name
            textViewUserEmail.text = user.email
            Glide.with(imageViewAvatar.context)
                .load(user.avatar)
                .into(imageViewAvatar)
        }

        init {
            itemView.setOnClickListener {
                itemClickListener.onItemClick(
                    users.get(adapterPosition),
                    adapterPosition,
                    "mainType"
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(users[position])
    }

    fun addData(list: List<User>) {
        users.addAll(list)
    }
}