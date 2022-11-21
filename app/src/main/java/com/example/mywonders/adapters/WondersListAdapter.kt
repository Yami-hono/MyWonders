package com.example.mywonders.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mywonders.R
import com.example.mywonders.database.Wonders
import com.example.mywonders.databinding.LiWondersBinding

class WondersListAdapter: RecyclerView.Adapter<WondersListAdapter.UserViewHolder>(){

    var data=ArrayList<Wonders>()

    fun setUpdatedList(data:ArrayList<Wonders>){
        this.data= data
        Log.i("myadapter", "setUpdatedList: $data")
        notifyDataSetChanged()
    }

    inner class UserViewHolder(var binding: LiWondersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Wonders) {

            Log.i("myadapter", "bind: $item")
            with(binding) {
                Glide.with(root.context)
                    .load(item.imageUrl)
                    .circleCrop()
                    .into(wonderImage)
                wonderName.text=item.name
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = DataBindingUtil.inflate<LiWondersBinding>(
            LayoutInflater.from(parent.context),
            R.layout.li_wonders,
            parent,
            false
        )
        Log.i("myadapter", "onCreateViewHolder: ")
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val searchResult = data.get(position)
        searchResult.let {
            holder.bind(searchResult)
            Log.i("myadapter", "onBindViewHolder: ")

        }
    }

    override fun getItemCount(): Int {
        Log.i("myadapter", "getItemCount: ${data.size}")
        return data.size
    }
}
