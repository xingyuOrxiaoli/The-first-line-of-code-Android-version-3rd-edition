package com.xiaoli.base.null_value

class NullValueMain1 {

    fun method1() = println("this is method1")
    fun method2() = println("this is method2")
}

fun isCheckNull_1(param1 :NullValueMain1?){
    if(param1 != null){
        param1.method1()
        param1.method2()
    }
}

// Kotlin提供的判空设定 使用 对象 + ?
fun isCheckNull_2(param1 :NullValueMain1?){
    param1?.method1()
    param1?.method2()
}
fun main(){
    isCheckNull_1(NullValueMain1())
    isCheckNull_2(NullValueMain1())

    // 进一步简化 ?: 进行简化如下
    val a = null
    val b = NullValueMain1()
    val c = if(a != null) a else b
    val d = a?:b

    // ?. 于 ?:组合使用简化
    val text = ""
    var e = text?.length ?: 0
    // 简化前的代码如下
    if(text != null) e = text.length
    else e = 0



    // let函数进行扩展,非空之后可以执行更多的逻辑
    b?.let { values ->
        values.method1()
        values.method2()
    }
}