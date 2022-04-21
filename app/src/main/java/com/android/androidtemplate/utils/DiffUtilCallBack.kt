package com.android.androidtemplate.utils

import androidx.recyclerview.widget.DiffUtil
import com.android.androidtemplate.data.model.User


/**
 * @Author: Abdul Rehman
 * @Date: 20/04/2022.
 */
class DiffUtilCallBack<T, O>(private val oldList: List<T>, private val newList: List<O>) :
    DiffUtil.Callback() {

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList.get(newItemPosition)
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList.get(newItemPosition)
    }

    override fun getNewListSize(): Int {
        return newList.size;
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }
}