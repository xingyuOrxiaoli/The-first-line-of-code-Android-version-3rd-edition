package com.xiaoli.listviewtest.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.xiaoli.listviewtest.R
import com.xiaoli.listviewtest.pojo.Fruit

class FruitAdapter(activity: Activity, val resourceId: Int, data: List<Fruit>) :
    ArrayAdapter<Fruit>(activity, resourceId, data) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // 第二个优化点： 每次在getView()方法中仍然会调用View的findViewById()方法来获取一次控件的实例。
        val viewHolder: ViewHolder

        // 第一个优化点： 因为在FruitAdapter的getView()方法中，每次都将布局重新加载了一遍，当ListView快速滚动的时候，这就会成为性能的瓶颈
        // 第一个优化点：优化点如下：
        val view : View
        if(convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId, parent, false)

            // 第二个优化点
            val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
            val fruitName: TextView = view.findViewById(R.id.fruitName)
            viewHolder = ViewHolder(fruitImage, fruitName)
            view.tag = viewHolder
        }
        else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }



        val fruit = getItem(position) // 获取当前项的Fruit实例
        if (fruit != null) {
            viewHolder.fruitImage.setImageResource(fruit.imageId)
            viewHolder.fruitName.text = fruit.name
        }
        return view
    }
    inner class ViewHolder(val fruitImage: ImageView, val fruitName: TextView)
}