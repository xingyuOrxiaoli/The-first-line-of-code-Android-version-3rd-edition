    package com.xiaoli.listviewtest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.xiaoli.listviewtest.adapter.RecyclerViewAdapter
import com.xiaoli.listviewtest.adapter.RecyclerViewAdapter2
import com.xiaoli.listviewtest.pojo.Fruit

    class RecyclerViewStaggeredGridLayoutManager : AppCompatActivity() {

    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_staggered_grid_layout_manager)

        initFruits() // 初始化水果数据
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        val recyclerView : RecyclerView = findViewById<RecyclerView>(R.id.recyclerView3)
        recyclerView.layoutManager = layoutManager
        val adapter = RecyclerViewAdapter2(fruitList)
        recyclerView.adapter = adapter


    }

        private fun initFruits() {
            repeat(2) {
                fruitList.add(Fruit(getRandomLengthString("Apple"),
                    R.drawable.apple_pic))
                fruitList.add(Fruit(getRandomLengthString("Banana"),
                    R.drawable.banana_pic))
                fruitList.add(Fruit(getRandomLengthString("Orange"),
                    R.drawable.orange_pic))
                fruitList.add(Fruit(getRandomLengthString("Watermelon"),
                    R.drawable.watermelon_pic))
                fruitList.add(Fruit(getRandomLengthString("Pear"),
                    R.drawable.pear_pic))
                fruitList.add(Fruit(getRandomLengthString("Grape"),
                    R.drawable.grape_pic))
                fruitList.add(Fruit(getRandomLengthString("Pineapple"),
                    R.drawable.pineapple_pic))
                fruitList.add(Fruit(getRandomLengthString("Strawberry"),
                    R.drawable.strawberry_pic))
                fruitList.add(Fruit(getRandomLengthString("Cherry"),
                    R.drawable.cherry_pic))
                fruitList.add(Fruit(getRandomLengthString("Mango"),
                    R.drawable.mango_pic))
            }
        }
        private fun getRandomLengthString(str: String): String {
            val n = (1..20).random()
            val builder = StringBuilder()
            repeat(n) {
                builder.append(str)
            }
            return builder.toString()
        }
    }