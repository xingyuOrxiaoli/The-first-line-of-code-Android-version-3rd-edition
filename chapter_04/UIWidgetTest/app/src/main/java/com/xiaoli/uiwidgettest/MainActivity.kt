package com.xiaoli.uiwidgettest

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity()  , View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button : Button = findViewById<Button>(R.id.button)
//        button.setOnClickListener {
//            // 点击时间的逻辑 方式一
//        }

        // 方式二 实现了View.OnClickListene接口
        button.setOnClickListener (this) // 这里会调用重写的ionClick方法



    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button -> {
                val inputText = findViewById<EditText>(R.id.editText).text.toString()
                Toast.makeText(this, inputText, Toast.LENGTH_SHORT).show()
                // 更换ImageView元素的照片
                findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.img_2)

                // 设置进度加载的可见性
                val progressBar = findViewById<ProgressBar>(R.id.progressBar)
                if (progressBar.visibility == View.VISIBLE) progressBar.visibility = View.GONE
                else progressBar.visibility = View.VISIBLE

                val progressBar2 = findViewById<ProgressBar>(R.id.progressBar2)
                progressBar2.progress = progressBar2.progress + 10
                // 对话框 AlertDialog
                AlertDialog.Builder(this).apply {
                    setTitle("This is Dialog")
                    setMessage("Something important.")
                    setCancelable(false)
                    setPositiveButton("OK") { dialog, which -> }
                    setNegativeButton("Cancel") { dialog, which ->}
                    show()
                }
            }
        }
    }
}