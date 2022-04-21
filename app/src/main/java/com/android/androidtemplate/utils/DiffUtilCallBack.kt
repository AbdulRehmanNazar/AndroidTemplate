package com.android.androidtemplate.utils

import androidx.recyclerview.widget.DiffUtil
import com.android.androidtemplate.data.model.User


/**
 * @Author: Abdul Rehman
 * @Date: 20/04/2022.
 */
class DiffUtilCallBack(private val oldList: List<User>, private val newList: List<User>) :
    DiffUtil.Callback() {

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList.get(newItemPosition)
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val (_, value, name) = oldList[oldItemPosition]
        val (_, value1, name1) = newList[newItemPosition]
        return name == name1 && value == value1
    }

    override fun getNewListSize(): Int {
        return newList.size;
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }
}