package com.xiaoli.networktest

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.sendRequestBtn).setOnClickListener {
            sendRequestWithHttpURLConnection()
        }
    }
    private fun sendRequestWithHttpURLConnection() {
        // 开启线程发起网络请求
        thread {
            var connection: HttpURLConnection? = null
            try {
                val response = StringBuilder()
                val url = URL("https://www.baidu.com")
                connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "POST"
                // 设置传入参数
                val output = DataOutputStream(connection.outputStream)
                output.writeBytes("username=username1&password=password1")

                connection.connectTimeout = 8000
                connection.readTimeout = 8000

                val input = connection.inputStream

                // 下面对获取到的输入流进行读取
                val reader = BufferedReader(InputStreamReader(input))
                reader.use {
                    reader.forEachLine {
                        response.append(it)
                    }
                }
                showResponse(response.toString())
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                connection?.disconnect()
            }
        }
    }
    private fun showResponse(response: String) {
        // 这个runOnUiThread()方法呢？别忘了，Android是不允许在子线程中进 行UI操作的
        runOnUiThread {
            // 在这里进行UI操作，将结果显示到界面上
            findViewById<TextView>(R.id.responseText).text = response
        }
    }
}