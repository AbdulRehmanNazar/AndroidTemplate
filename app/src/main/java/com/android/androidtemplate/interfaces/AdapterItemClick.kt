package com.android.androidtemplate.interfaces


/**
 * @Author: Abdul Rehman
 * @Date: 20/04/2022.
 */
interface AdapterItemClick<T> {
    fun onItemClick(item: T?, position: Int, type: String)
}