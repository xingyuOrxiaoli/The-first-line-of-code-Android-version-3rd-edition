package com.xiaoli.viewholder

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xiaoli.viewholder.adapter.MsgAdapter
import com.xiaoli.viewholder.pojo.Msg

class MainActivity2 : AppCompatActivity() , View.OnClickListener {

    private val msgList = ArrayList<Msg>()

    private var adapter: MsgAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        initMsg()
        val layoutManager = LinearLayoutManager(this)
        val recyclerView : RecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        adapter = MsgAdapter(msgList)
        recyclerView.adapter = adapter
        val send : Button = findViewById<Button>(R.id.send)
        send.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            findViewById<Button>(R.id.send) -> {
                val inputText = findViewById<EditText>(R.id.inputText)
                val recyclerView : RecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                val content = inputText.text.toString()
                if (content.isNotEmpty()) {
                    val msg = Msg(content, Msg.TYPE_SENT)
                    msgList.add(msg)
                    adapter?.notifyItemInserted(msgList.size - 1) // 当有新消息时，
//                    刷新RecyclerView中的显示
                    recyclerView.scrollToPosition(msgList.size - 1) // 将RecyclerView
//                    定位到最后一行
                    inputText.setText("") // 清空输入框中的内容
                }
            }
        }
    }

    private fun initMsg() {
        val msg1 = Msg("Hello guy.", Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("Hello. Who is that?", Msg.TYPE_SENT)
        msgList.add(msg2)
        val msg3 = Msg("This is Tom. Nice talking to you. ", Msg.TYPE_RECEIVED)
        msgList.add(msg3)
    }
}