package com.xiaoli.activitytest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : BaseActivity() {

    /**
     * 通过静态方法解决 对接传递哪些数据的问题
     * SecondActivity中需要的数据都是通过actionStart()方法的参数传递过来的
     */
    companion object {
        fun actionStart(context: Context, data1: String, data2: String) {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra("param1", data1)
            intent.putExtra("param2", data2)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        /**
         * 上述代码中的intent实际上调用的是父类的getIntent()方法，该方法会获取用于启动
         * SecondActivity的Intent，然后调用getStringExtra()方法并传入相应的键值，就可以得到传递的数据了。
         * 这里由于我们传递的是字符串，所以使用getStringExtra()方法来获取传递的数据。
         * 如果传递的是整型数据，则使用getIntExtra()方法；如果传递的是布尔型数据，
         * 则使用getBooleanExtra()方法，以此类推。
         *
         */
        val extraData = intent.getStringExtra("extra_data")
        Log.d("SecondActivity", "extra data is $extraData")
        val button2 : Button  = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data_return", "Hello FirstActivity")
            setResult(RESULT_OK, intent)
            finish()
        }

    }
}