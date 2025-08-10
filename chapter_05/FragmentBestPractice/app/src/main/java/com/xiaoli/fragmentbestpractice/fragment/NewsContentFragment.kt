package com.xiaoli.fragmentbestpractice.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.xiaoli.fragmentbestpractice.MainActivity
import com.xiaoli.fragmentbestpractice.R

class NewsContentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    fun refresh(title: String , content:String){


        val mainActivity = activity as MainActivity

        val contentLayout : LinearLayout = mainActivity.findViewById<LinearLayout>(R.id.contentLayout)
        val newsTitle : TextView = mainActivity.findViewById<TextView>(R.id.newsTitle)
        val newsContent : TextView = mainActivity.findViewById<TextView>(R.id.newsContent)

        contentLayout.visibility = View.VISIBLE
        newsTitle.text = title // 刷新新闻的标题
        newsContent.text = content // 刷新新闻的内容
    }
}