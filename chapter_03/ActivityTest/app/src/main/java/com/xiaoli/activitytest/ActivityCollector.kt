package com.xiaoli.activitytest

import android.app.Activity


/**
 * 如果目前你手机的界面还停留在ThirdActivity，你会发现当前想退出程序是非常不方便的，需
 * 要连按3次Back键才行。按Home键只是把程序挂起，并没有退出程序。如果我们的程序需要
 * 注销或者退出的功能该怎么办呢？看来要有一个随时随地都能退出程序的方案才行。
 */
object ActivityCollector {

    private val activities = ArrayList<Activity>()
    fun addActivity(activity: Activity) {
        activities.add(activity)
    }
    fun removeActivity(activity: Activity) {
        activities.remove(activity)
    }
    fun finishAll() {
        for (activity in activities) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
        activities.clear()
    }
}