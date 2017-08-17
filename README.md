天职师大URP系统成绩查询库
======================================================
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
>
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

MySchoolScoreActivity的用法
----------------------------------
**只有一步哦，在你需要的地方调用下面的方法** 
```adnroid 
    startActivity(MyScoreActivity.toScoreActivity(this,"account","password"))
```
account是你的学号，password是你的密码

联系我
-------
 **邮箱:** gioppl@vip.qq.com
