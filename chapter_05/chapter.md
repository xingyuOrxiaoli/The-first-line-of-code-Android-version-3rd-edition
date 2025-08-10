# 手机平板要兼顾，探究Fragment

## 动态添加Fragment


被替换的xml的设置
```xml
<!--    动态添加Fragment-->
    <FrameLayout
        android:id="@+id/rightLayout"
        android:layout_width="0dp"
        android:layout_height="match_parent"
        android:layout_weight="1" >
    </FrameLayout>
```

动态替换的Kotlin逻辑代码：

(1) 创建待添加Fragment的实例。

(2) 获取FragmentManager，在Activity中可以直接调用getSupportFragmentManager()方法获取。

(3) 开启一个事务，通过调用beginTransaction()方法开启。

(4) 向容器内添加或替换Fragment，一般使用replace()方法实现，需要传入容器的id和待添加的Fragment实例。

(5) 提交事务，调用commit()方法来完成。

```kotlin
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.rightLayout, fragment)
        transaction.commit()
    }
```


## Fragment和Activity进行交互
FragmentManager提供了一个类似于findViewById()的方法，专门用于从布局文件中获取Fragment的实例
```kotlin
val fragment = supportFragmentManager.findFragmentById(R.id.leftFrag) as LeftFragment
```
在每个Fragment中都可以通过调用getActivity()方法来得到和当前Fragment相关联的Activity实例


```kotlin
    if (activity != null) {
        val mainActivity = activity as MainActivity
    }
```

## Fragment的生命周期
01. 运行状态
当一个Fragment所关联的Activity正处于运行状态时，该Fragment也处于运行状态。
02. 暂停状态
当一个Activity进入暂停状态时（由于另一个未占满屏幕的Activity被添加到了栈顶），与
它相关联的Fragment就会进入暂停状态。
03. 停止状态
当一个Activity进入停止状态时，与它相关联的Fragment就会进入停止状态，或者通过调
用FragmentTransaction的remove()、replace()方法将Fragment从Activity中移
除，但在事务提交之前调用了addToBackStack()方法，这时的Fragment也会进入停止
状态。总的来说，进入停止状态的Fragment对用户来说是完全不可见的，有可能会被系统
回收。
04. 销毁状态
Fragment总是依附于Activity而存在，因此当Activity被销毁时，与它相关联的
Fragment就会进入销毁状态。或者通过调用FragmentTransaction的remove()、
replace()方法将Fragment从Activity中移除，但在事务提交之前并没有调用
addToBackStack()方法，这时的Fragment也会进入销毁状态。


## 动态加载布局的技巧

使用限定符



## 扩展函数
定义扩展函数只需要在函数名的前面加上一个ClassName.的语法结构，就表示将该函数添加到指定类当中了扩展函数的使用模板如下：
```kotlin
fun ClassName.methodName(param1: Int, param2: Int): Int {
 return 0
}
```

## 运算符重载
运算符重载使用的是operator关键字，只要在指定函数的前面加上operator关键字，就可以实现运算符重载的功能了。
1. plus 对应的 +
```kotlin
class Obj {
    operator fun plus(obj: Obj): Obj {
    // 处理相加的逻辑
    }
}
val obj1 = Obj()
val obj2 = Obj()
val obj3 = obj1 + obj2
```

对运算符的扩展如下代码：
```kotlin
class Money(val value: Int) {
    operator fun plus(money: Money): Money {
        val sum = value + money.value
        return Money(sum)
    }
    operator fun plus(newValue: Int): Money {
        val sum = value + newValue
        return Money(sum)
    }
}
val money1 = Money(5)
val money2 = Money(10)
val money3 = money1 + money2
val money4 = money3 + 20
println(money4.value)

```


关于Kotlin运算符重载语法糖的对应表如下图：
![
    
    
](image.png)