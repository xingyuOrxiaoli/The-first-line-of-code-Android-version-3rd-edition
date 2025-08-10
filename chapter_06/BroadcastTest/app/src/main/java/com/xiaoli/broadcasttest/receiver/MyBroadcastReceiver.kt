package com.xiaoli.broadcasttest.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "received in MyBroadcastReceiver", Toast.LENGTH_SHORT).show()

        // 广播阶段，后面的广播接收器BroadcastReceiver 将无法在接收到这条广播
        abortBroadcast()
    }
}