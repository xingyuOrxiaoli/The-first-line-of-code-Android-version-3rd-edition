package com.xiaoli.listviewtest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.xiaoli.listviewtest.adapter.RecyclerViewAdapter2
import com.xiaoli.listviewtest.pojo.Fruit

class RecyclerViewGridLayoutManager : AppCompatActivity() {

    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_grid_layout_manager)

        initFruits() // 初始化水果数据
        val layoutManager = GridLayoutManager(this,5, GridLayoutManager.VERTICAL , false)
        val recyclerView : RecyclerView = findViewById<RecyclerView>(R.id.recyclerView4)
        recyclerView.layoutManager = layoutManager
        val adapter = RecyclerViewAdapter2(fruitList)
        recyclerView.adapter = adapter

    }

    private fun initFruits() {
        repeat(1) {
            fruitList.add(Fruit("Apple", R.drawable.apple_pic))
            fruitList.add(Fruit("Banana", R.drawable.banana_pic))
            fruitList.add(Fruit("Orange", R.drawable.orange_pic))
            fruitList.add(Fruit("Watermelon", R.drawable.watermelon_pic))
            fruitList.add(Fruit("Pear", R.drawable.pear_pic))
            fruitList.add(Fruit("Grape", R.drawable.grape_pic))
            fruitList.add(Fruit("Pineapple", R.drawable.pineapple_pic))
            fruitList.add(Fruit("Strawberry", R.drawable.strawberry_pic))
            fruitList.add(Fruit("Cherry", R.drawable.cherry_pic))
            fruitList.add(Fruit("Mango", R.drawable.mango_pic))
        }
    }

}