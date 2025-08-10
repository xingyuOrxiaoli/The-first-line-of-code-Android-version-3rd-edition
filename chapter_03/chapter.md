# 先从看得到的入手，探究Activity



## Activity 的声明周期


## Activity 的启动模式

启动模式一共有4种，分别是
1. standard   ： 在standard模式下，每当启动一个新的Activity，它就会在返回栈中入栈，并处于栈顶的位置。对于使用standard模式的Activity，系统不会在乎这个Activity是否已经在返回栈中存在，每次启动都会创建一个该Activity的新实例。
2. singleTop ： 在启动Activity时如果发现返回栈的栈顶已经是该Activity，则认为可以直接使用它，不会再创建新的Activity实例。
3. singleTask ： 使用singleTop模式可以很好地解决重复创建栈顶Activity的问题，每次启动该Activity时，系统首先会在返回栈中检查是否存在该Activity的实例，如果发现已经存在则直接使用该实例，并把在这个Activity之上的所有其他Activity统统出栈，如果没有发现就会创建一个新的
Activity实例。
4. singleInstance ： 会有一个单独的返回栈来管理这个Activity，不管是哪个应用程序来访问这个Activity，都共用同一个返回栈，也就解决了共享Activity实例的问题。

可以在AndroidManifest.xml中通过给<activity>标签指定android:launchMode属性来选择启动模式。下面我们来逐个进行学习。





## Activity的最佳实现


```kotlin
// 杀掉进程的代码
android.os.Process.killProcess(android.os.Process.myPid())
```

## 标准函数

### with
语法规则如下:
1. 第一个参数可以是一个任意类型的对象
2. 第二个参数是一个Lambda表达式
3. 最后一行代码作为返回值返回
```kotlin

// 语法模板
val result = with(obj) {
    // 这里是obj的上下文
    "value" // with函数的返回值
}


// 遍历打印集合list
val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
val builder = StringBuilder()
builder.append("Start eating fruits.\n")
for (fruit in list) {
    builder.append(fruit).append("\n")
}
builder.append("Ate all fruits.")
val result = builder.toString()
println(result)

// 使用with函数简化如下：
val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
val result = with(StringBuilder()) {
    append("Start eating fruits.\n")
    for (fruit in list) {
        append(fruit).append("\n")
    }
    append("Ate all fruits.")
    toString()
}
println(result)


```


### run 
语法规则如下:
1. 只接收一个Lambda参数
2. Lambda表达式中提供调用对象的上下文
3. 使用Lambda表达式中的最后一行代码作为返回值返回
```kotlin

// 语法模板
val result = obj.run {
    // 这里是obj的上下文
    "value" // run函数的返回值
}


// 遍历打印集合list
val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
val builder = StringBuilder()
builder.append("Start eating fruits.\n")
for (fruit in list) {
    builder.append(fruit).append("\n")
}
builder.append("Ate all fruits.")
val result = builder.toString()
println(result)

// 使用run函数简化如下：
val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
val result = StringBuilder().run {
    append("Start eating fruits.\n")
    for (fruit in list) {
        append(fruit).append("\n")    }
    append("Ate all fruits.")
    toString()
}
println(result)

```

### apply

语法规则如下:
1. 只接收一个Lambda参数
2. Lambda表达式中提供调用对象的上下文
3. 无法指定返回值，而是会自动返回调用对象本身回值返回
```kotlin

// 语法模板
val result = obj.apply {
     // 这里是obj的上下文
}
// result == obj


// 遍历打印集合list
val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
val builder = StringBuilder()
builder.append("Start eating fruits.\n")
for (fruit in list) {
    builder.append(fruit).append("\n")
}
builder.append("Ate all fruits.")
val result = builder.toString()
println(result)

// 使用apply函数简化如下：
val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")val result = StringBuilder().apply {
    append("Start eating fruits.\n")
    for (fruit in list) {
        append(fruit).append("\n")
    }
    append("Ate all fruits.")
}
println(result.toString())

```

## 定义静态方法


使用companion object或者创建一个单例类来实现类似静态方法的功能，但其中的方法并不是静态方法，这些方法都会定义一个伴生类或者单例类的示例方法
```kotlin
companion object {
    fun doAction2() {
        println("do action2")        
    }
}

```

kotlin提供实现静态方法的两种方式如下：
1. 使用注解 @JvmStatic：@JvmStatic注解只能加在单例类或companion object中的方法上，
2. 顶层方法
```kotlin
companion object {
    @JvmStatic
    fun doAction2() {
        println("do action2")        
    }
}

```


