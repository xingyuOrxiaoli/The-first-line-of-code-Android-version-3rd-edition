package com.xiaoli.activitytest

import android.annotation.SuppressLint
import android.app.ComponentCaller
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 启动模式的观察
        Log.d("FirstActivity", this.toString())

        setContentView(R.layout.activity_first)

        val button : Button  = findViewById<Button>(R.id.button1)
        button.setOnClickListener {
            Toast.makeText(this,"you click Button 1" , Toast.LENGTH_SHORT).show()

            // 显式 ： Intent
//            val intent = Intent(this, SecondActivity::class.java)
            // 隐式 ： Intent
//            val intent = Intent("com.example.activitytest.ACTION_START")
//            intent.addCategory("android.intent.category.DEFAULT")
            // 无返回值的传递
//            startActivity(intent)

            // 更多隐式用法
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse("https://www.baidu.com")

//            val intent = Intent(Intent.ACTION_DIAL)
//            intent.data = Uri.parse("tel:10086")

            /**
             * 我们还可以在<intent-filter>标签中再配置一个<data>标签，用于更精确地指定当前Activity能够响应的数据。<data>标签中主要可以配置以下内容。
             *
             * android:scheme。用于指定数据的协议部分，如上例中的https部分。
             * android:host。用于指定数据的主机名部分，如上例中的www.baidu.com部分。
             * android:port。用于指定数据的端口部分，一般紧随在主机名之后。
             * android:path。用于指定主机名和端口之后的部分，如一段网址中跟在域名之后的内容。
             * android:mimeType。用于指定可以处理的数据类型，允许使用通配符的方式进行指定。
             *
             * 只有当<data>标签中指定的内容和Intent中携带的Data完全一致时，
             * 当前Activity才能够响应该Intent。不过，在<data>标签中一般不会指定过多的内容。、
             * 例如在上面的浏览器示例中，其实只需要指定android:scheme为https，
             * 就可以响应所有https协议的Intent了。
             */


            // Intent传递数据
            val data = "Hello SecondActivity"
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("extra_data" , data)

            // 没有返回值的Intent
//            startActivity(intent)

            // 带有返回值的
            startActivityForResult(intent, 1)

        // 销毁一个Activity
//            finish()
        }


    }


    @SuppressLint("GestureBackNavigation")
    @Deprecated("This method has been deprecated in favor of using the\n      {@link OnBackPressedDispatcher} via {@link #getOnBackPressedDispatcher()}.\n      The OnBackPressedDispatcher controls how back button events are dispatched\n      to one or more {@link OnBackPressedCallback} objects.")
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent()
        intent.putExtra("data_return", "Hello FirstActivity")
        setResult(RESULT_OK, intent)
        finish()
    }


    /**
     * 由于我们是使用startActivityForResult()方法来启动SecondActivity的，在
     * SecondActivity被销毁之后会回调上一个Activity的onActivityResult()方法，因此我们需要在FirstActivity中重写这个方法来得到返回的数据，如下所示：
     *
     * 第一个参数requestCode，即我们在启动Activity 时传入的请求码；第二个参数resultCode，即我们在返回数据时传入的处理结果；第三个参数data，即携带着返回数据的Intent。由于在一个Activity中有可能调用
     * startActivityForResult()方法去启动很多不同的Activity，每一个Activity返回的数据都会回调到onActivityResult()这个方法中，因此我们首先要做的就是通过检查
     * requestCode的值来判断数据来源。确定数据是从SecondActivity返回的之后，我们再通过
     * resultCode的值来判断处理结果是否成功。最后从data中取值并打印出来，这样就完成了向上一个Activity返回数据的工作。
     *
     */
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?,
        caller: ComponentCaller
    ) {
        super.onActivityResult(requestCode, resultCode, data, caller)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                val returnedData = data?.getStringExtra("data_return")
                Log.d("FirstActivity", "returned data is $returnedData")
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.add_item -> Toast.makeText(this, "You clicked Add",
                Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "You clicked Remove",
                Toast.LENGTH_SHORT).show()
        }

        return true;
    }

}