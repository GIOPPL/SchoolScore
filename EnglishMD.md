The query student score library of Tianjin University Tianjin University of Technology and Education URP system
======================================================

**[中文点击这里](https://github.com/GIOPPL/SchoolScore/blob/master/README.md)**

Project fuction
-------------------
> query someone score 
>
> you only need provide your account and password  


Theory directions
--------
> 1.we use Firefox browser cheack package，the login address is <http://202.113.244.44:9012/loginAction.do>
>
> 2.the address of score query is <http://202.113.244.44:9012/xkAction.do?actionType=6>
>>arg1：zjh，student number
>>
>>arg2：mm,password
>>
>
> 3.use jsoup analyze the xml

modle illustration
-------
> 1.MVP modle
>
> 2.RxJava encapsulation

Installation
---------
**Step 1.** Add it in your root build.gradle at the end of repositories:
```groovy
allprojects {
	   repositories {
		        ...
		        maven { url 'https://jitpack.io' }
	   }
}
```

**Step 2.** Add the dependency in your APP build.gradle
```groovy
dependencies {
	    compile 'com.github.GIOPPL:SchoolScore:071ea9d7da'
}
```

Usage of MySchoolScoreActivity
----------------------------------
**only one step，you can use this code where you need in your project** 
```adnroid 
    startActivity(MyScoreActivity.toScoreActivity(this,"account","password"))
```
account is your student number，password is your password

link me
-------
 **QQ:** gioppl@vip.qq.com
