天职师大URP系统成绩查询库(PPL)
======================================================
>英文文档没写全，实在不想翻译
**[The English document click here](https://github.com/GIOPPL/SchoolScore/blob/master/EnglishMD.md)**

项目功能
-------------------
>用自己的学号和密码查询URP成绩
>
>仅仅需要提供账号密码，查询跳转自己完成

原理说明
--------
> 1.用火狐浏览器抓的包，登陆地址为<http://202.113.244.44:9012/loginAction.do>
>
> 2.成绩查询的地址为<http://202.113.244.44:9012/xkAction.do?actionType=6>
>>参数1：zjh，学号
>>
>>参数2：mm,密码
>>
> 3.用jsoup解析xml文档

架构说明
-------
> 1.MVP架构
>
> 2.RxJava封装

项目引用
---------
**Step 1.** 在你根目录下build.gradle最后的repositories中添加:
```groovy
allprojects {
	   repositories {
		        ...
		        maven { url 'https://jitpack.io' }
	   }
}
```

**Step 2.** 在你的APP的build.gradle中的dependency中添加
```groovy
dependencies {
	    compile 'com.github.GIOPPL:SchoolScore:071ea9d7da'
}
```

MySchoolScoreActivity自动界面的用法
----------------------------------
**只有一步哦，在你需要的地方调用下面的方法** 
```adnroid 
    startActivity(MyScoreActivity.toScoreActivity(this,"account","password"))
```
account是你的学号，password是你的密码

获取成绩信息的用法
----------------------------------
**原本是xml数据，已经解析成ArrayLsiy<ScoreEnity>** 
#### step 1,实现接口ScoreView

>kotlin 应用中方法
```kotlin 
    fun onSuccess(xml: ArrayList<ScoreEntity>)
    fun onError(result:String)
```
>java 应用中方法
```android
    @override
    void OnSuccess(ArrayList<ScoreEntity> xml)
    @override
    void OnError(result:String)
```
#### step 2,
>kotlin 应用中方法
```kotlin
    var mPresent=ScorePresent(this);
    mPresent!!.getScore("学号","密码")
```
>java 应用中方法
```java
    ScorePresent mPresent=ScorePresent(this);
    mPresent.getScore("学号","密码")
```
#### step 3
> 然后就等着数据从OnSuccess()中传进来把

注意
--------
**要是出现下面这种情况，请在你的AndroidManifest.xml中的application上加上网络许可**
```xml
    <uses-permission android:name="android.permission.INTERNET" />
```

![error](https://github.com/GIOPPL/SchoolScore/blob/master/error_image.png)

联系我
-------
 **邮箱:** gioppl@vip.qq.com
