# BaseApp
App开发基本框架
开发须知:
## 一、JAVA篇
* 所有Activity请务必继承BaseActivity。
* 避免将Activity作为Context在函数中传递，绝大多数情况下用MyApplication.getContext（）替代。
* 尽量减少内部类的使用（一般内部类会对外部类有引用）。
* 所有Log打印请使用LogUtil打印。
* Toast Snackbar请尽量使用相关Utils。
* 所有for循环请使用 int size = size(); for (int i = 0, i < size, i++) {}结构。
* 尽量避免使用+做String拼接。
* 在Activity的onDestroy()方法中反注册掉监听器、释放Handler。
* 不要使用死循环发送网络请求：）
* 将耗时任务从main线程移除到其他线程。
## 二、Res篇
* Layout视图尽量使用RelativeLayout，减少视图层级嵌套，方便后期修改，如无必要请使用FrameLayout、LinearLayou等简单布局。
* 尽可能不要在RelativeLayout中嵌套带内部View带weight的LinearLayout。
* 对于重复使用的属性请抽象到styles中，命名请使用common、视图或逻辑作为前缀。
* 其他相关资源如果android：XXX中有就不要再私自定义。如： color balck， color white。
* 图片请使用tinypng进行压缩。
* 定义res前请检查是否已有相关资源，避免重复定义。
## 三、libs篇
* 尽量减少非必要类库。
* 如果google有官方相关类库，请优先使用google类库。
* 尽量减少工程相互依赖，代码能放入主工程就放入主工程。

  **[常用类库](https://github.com/iMeePwni/BaseApp/blob/master/CommonLibs.md)**
  **[GitHub上排名前100的Android开源库进行简单的介绍](http://www.open-open.com/lib/view/open1457531611171.html)**
## 四、优化篇 
* 过度绘制（开发者选项 显示过度绘制）。
* 内存泄露（Android Studio -> Analysis Tasks）。
* 电池优化。
* CPU使用（Profile）。

  **请查看光头哥捣蛋弟相关视频[Udacity 性能优化](https://cn.udacity.com/course/android-performance--ud825)**,**[优化文章精选](http://www.jianshu.com/p/525e9d555cf3)**  
## 五、常用网站篇
* 开发者资源。

  **[阿里巴巴图标](http://www.iconfont.cn/)**
* 开源代码

  **[泡在网上的日子](http://www.jcodecraeer.com/)**,**[CTOLib](http://www.ctolib.com/categories/android-app.html)**
* 工具网站

  **[菜鸟工具](https://c.runoob.com/)**,**[开发工具](http://www.androiddevtools.cn/)**,[tinypng](https://tinypng.com/)
## 六、范例篇
### Activity范例
```

public class LogoActivity extends BaseActivity {
	public static final int LOGIN_SELECT = 1;
	public static final int LOGIN_SUC = 2;
	public static final int DEVICE_CHOICE = 3;
	public static final int UPDATE = 4;
// 不要过度使用static、final
 Handler mHandler = new Handler() {  
		public void handleMessage(Message msg) {
			finish();
	 	};
};
private CountDownTimer timer = new CountDownTimer(6 * 1000, 1 * 1000) {
		@Override
		public void onTick(long millisUntilFinished) {
		}
		@Override
		public void onFinish() {
			showToast("连接超时请稍后重试");
			finish();
		}
};		
private AnimatorSet animSet = new AnimatorSet();
animSet.addListener(new AnimatorListener() {
		@Override
		public void onAnimationStart(com.nineoldandroids.animation.Animator animation) {
		iconFace.setEnabled(false);
		}
		@Override
		public void onAnimationRepeat(com.nineoldandroids.animation.Animator animation) {
		}
		@Override
		public void onAnimationEnd(com.nineoldandroids.animation.Animator animation) {
		iconFace.setEnabled(true);
		}
		@Override
		public void onAnimationCancel(com.nineoldandroids.animation.Animator animation) {
		}
});
	@Override
	public void finish() {
// 注销		
		timer.cancel();
// 清空		
		mHandler.removeCallbacksAndMessages(null);
// 反注册
  		animSet.removeAllListeners();
		super.finish();
	}
}

```


   


