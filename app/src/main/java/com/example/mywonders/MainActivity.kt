package com.example.mywonders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.mywonders.adapters.WondersListAdapter
import com.example.mywonders.database.Wonders
import com.example.mywonders.database.WondersDatabase
import com.example.mywonders.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var wonderAdapter: WondersListAdapter

    lateinit var binding: ActivityMainBinding

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel.database= Room.databaseBuilder(applicationContext,
            WondersDatabase::class.java,
            "PostTable")
            .fallbackToDestructiveMigration()
            .build()

        val layoutManager =  GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        binding.wondersRecyclerView.layoutManager = layoutManager

//        viewModel.deleteAll()                                 to delete whole data from the local  database
        wonderAdapter= WondersListAdapter()
        binding.wondersRecyclerView.adapter=wonderAdapter


        addObserver()

    }

    private fun addObserver(){

        viewModel.database.contactDAO().getdata().observe(this){
            if(it.isNotEmpty()) wonderAdapter.setUpdatedList(it as ArrayList<Wonders> )
            else{
               viewModel.putData()

            }

        }
    }
}