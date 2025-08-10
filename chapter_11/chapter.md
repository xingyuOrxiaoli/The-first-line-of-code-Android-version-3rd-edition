# 看看精彩的世界，使用网络技术


## webView

程序使用到了网络功能为此需要在AndroidManifest.xml中声明如下代码：
```xml
    <uses-permission android:name="android.permission.INTERNET" />
```

在页面xml配置如下：
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:fitsSystemWindows="true"
    >

    <WebView
        android:id="@+id/webView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        />

</LinearLayout>
```

kotlin代码设置如下：
```kotlin
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView : WebView = findViewById<WebView>(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.baidu.com")
    }
}

``` 


## HttpURLConnection

创建连接对象
```kotlin
val url = URL("https://www.baidu.com")
val connection = url.openConnection() as HttpURLConnection
```
设置请求方式
```kotlin
connection.requestMethod = "GET"
```
其它参数的设置，如下：
```kotlin
// 设置连接超时的毫秒数
connection.connectTimeout = 8000
// 读取超时的毫秒数
connection.readTimeout = 8000
```

获取服务器响应的输入流
```kotlin
val input = connection.inputStream
```

最后关闭输入流

```kotlin
connection.disconnect()
```

## 开源网络通信库OkHttp

github主页：https://github.com/square/okhttp。

引入OkHttp依赖
```gradle
implementation 'com.squareup.okhttp3:okhttp:4.1.0'
```

1. 创建OkHttpClient实例
```kotlin
val client = OkHttpClient()
```
2. 创建请求Request对象

```kotlin
val request = Request.Builder().build()

// 上述是创建一个空的请求对象，一般都要在build之前进行配置如下：
val request = Request.Builder()
    .url("https://www.baidu.com")
    .build()
```

3. 创建Call对象，并调用它的execute()发送请求并接受响应数据
```kotlin
val response = client.newCall(request).execute()
// 对于post请求来说，需要线构建一个Request Body 对象来存放发送的数据
val requestBody = FormBody.Builder()
    .add("username", "admin")
    .add("password", "123456")
    .build()

 // 之后发送请求
 val request = Request.Builder()
    .url("https://www.baidu.com")
    .post(requestBody)
    .build()
```

4. 获取响应数据
```kotlin
val responseData = response.body?.string()
```

## XML解析




