# 软件也要拼脸蛋，UI开发的点点滴滴

## 控件


### 常规属性

是否可见
1. visible(默认值，可见)
2. invisible：控件不可见，但是它仍然占据着原来的位置和大小
3. gone ： 表示控件不仅不可见，而且不再占用任何屏幕空间

1. android:padding表示给控件的周围加上补白，这样不至于让文本内容紧靠在边缘上；
2. android:maxLines设置为1表示让这个TextView只能单行显示；
3. android:ellipsize用于设定当文本内容超出控件宽度时文本的缩略方式，这里指定成end表示在尾部进行缩略

```xml
<TextView xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/newsTitle"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:maxLines="1"
    android:ellipsize="end"
    android:textSize="18sp"
    android:paddingLeft="10dp"
    android:paddingRight="10dp"
    android:paddingTop="15dp"
    android:paddingBottom="15dp" />

```


## 布局

### 线性布局 LinearLayout


### 相对布局 RelativeLayout

1. 相对父布局的定位
2. 控件相对于控件进行定位   

### 帧布局 FrameLayout
所有的控件都会默认摆放在布局的左上角



### 自定义布局

引入自定义布局的标签使用如下

```xml
   <include layout="@layout/title" />

```
## 延迟初始化

使用关键字修饰lateinit
```kotlin
private lateinit var adapter: MsgAdapter

// 判断是否完成了初始化操作
if (!::adapter.isInitialized) {
 adapter = MsgAdapter(msgList)
 }

```


## 密封类
sealed关键字 + 子类继承必须加上()
```kotlin 
sealed class Result
class Success(val msg: String) : Result()
class Failure(val error: Exception) : Result()

fun getResultMsg(result: Result) = when (result) {
 is Success -> result.msg
 is Failure -> "Error is ${result.error.message}"
}
```
