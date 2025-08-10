package com.xiaoli.fragmenttest

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.xiaoli.fragmenttest.fragment.AnotherRightFragment
import com.xiaoli.fragmenttest.fragment.LeftFragment
import com.xiaoli.fragmenttest.fragment.RightFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button : Button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            replaceFragment(AnotherRightFragment())
        }
        replaceFragment(RightFragment())

        val fragment = supportFragmentManager.findFragmentById(R.id.leftFrag) as LeftFragment

    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.rightLayout, fragment)

        // 实现Fragment 的返回栈功能 ：  实现
        transaction.addToBackStack(null)
        transaction.commit()
    }
}