天津职业技术师范大学URP系统成绩查询的库
======================================================
项目功能
-------------------
>用自己的学号和密码查询URP成绩
>
>仅仅需要提供账号密码，查询跳转自己完成

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
 **QQ:** gioppl@vip.qq.com
