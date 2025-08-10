package com.xiaoli.base.var_fun

import kotlinx.coroutines.android.awaitFrame

class FunMain {


}

fun main() : Unit{
    var a : Int = 10
    // if条件判断
    if(a > 10){
        a = 20
    }else if(a > 5){
        a = 40
    }else {
        a = 80
    }
    // kotlin的语法糖
    var b = if(a > 10) 20 else if (a > 5) 30 else 100

    // when语句
    when(b){
        20 -> println("a > 10")
        30 -> println("a > 5")
        100 -> println("a <= 5")
        is Int -> println("fff")
    }
    // Number数值类型 内置的抽象类 所有数字相关的类型都是其子类 这里也可以看到Kotlin相比Java面向对象做的更加完善
    var c : Number = 10L
    when(c){
        is Int -> println("a > 10")
        is Double -> println("a > 5")
//        else -> println("a <= 5")
    }

    // [0 , 10]区间的值 这里相对python语言的在区间的开闭有一定区别
    var range = 0..10
    // 使用forin 循环
    for (i in range) println(i)
    // [0,10)
    for (i in 0 until 10) println(i)
    // [0,2 , 4 , 6, 8) 设置步长
    for (i in 0 until 10 step 2) println(i)
    // 逆序 关键字 downTo [10 , 1]
    for (i in 10 downTo  1) println(i)





}
    // 参数 + 返回值
    fun funName01(param1:Int , param2: ArrayList<String>) : Map<Int, String>? { return null }
    // 无参 + 返回Unit(无返回值类型 对应void)可以不写
    fun funName02(){}
    // 可变参数 + 无返回值
    fun funName03(param1:Int  , vararg param2:String){}

// 函数体只有一行的 使用 =
fun funName01(param1: Int , param2:Int) : Int = param1 + param2
// 函数体只有一行的 + 类型推到 可以省去返回值的声明
fun funName02(param1: Int ,param2: Int) = param1 + param2


