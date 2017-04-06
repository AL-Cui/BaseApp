# BaseApp
App开发基本框架
开发须知:
## 排版
* (1)代码缩进:代码块要采用缩进风格编写，缩进的空格数为4个
* (2)长句分割:较长的语句、表达式或者参数（>80字符）要分成多行书写.例如：
<pre><code>
if(condition1
   && condition2
   && condition3){
   Log.d("tag","Session destroyedcall-id"
   ＋ event.getSession().getCallId())};
</code></pre>
* (3)一句一行:不允许把多个短语句写在一行中，即一行只写一条语句。
* String name = "Mr.Simple"; String addr = "北京市";
* 推荐的形式:
* String name = "Mr.Simple";
* String addr = "北京市";
* (4)大括号:If、for、do、while、case、switch、default等语句自占一行，且If、for、do、while、switch等语句的执行语句无论多少都要加括号｛｝，尤其是只有一行语句的情况下容易忽略掉"{}",case 的语句中如果定义变量必须加括号{}。
* (5)空行分隔:相对独立的程序块、变量、函数之间必须加空行。有关联的代码紧凑在一起，相对无关的代码需要一个空行分离，使代码更加清晰。有两个以上的关键字、变量、常量进行对等操作时，它们之间的操作符前后要加空格，进行非对等操作时，如果是关系密切的立即操作，如“.”,则不应该加空格。
* (6)数据与函数的排布:类属性和类定义不要交叉放置，不同存取范围的属性或者方法也尽量不要交叉放置。
<pre><code>
类定义 {
	类的公有属性定义;
	类的保护属性定义;
	类的私有属性定义;
	类的公有方法定义;
	类的保护方法定义;
	类的私有方法定义;
	}
</code></pre>
* (7)修饰词按照指定顺序书写:［访问权限］［static］［final］
## 注释
* （1）类注释：类和接口的注释放在class或者interface关键字之前，import关键字之后，没有import可放在package之后。类注释一般采用如下格式：
<pre><code>
/**
*一句话功能描述
*功能详细描述
*@author ［作者］（必须）
*@see ［相关类／方法］（可选）
*@since［产品／模块版本］（必须）
*@deprecated（可选）
*/
</code></pre>
* （2）注释的位置：类成员变量、公有和保护方法需要写注释，写在被注释元素的上面，并与其上面的代码用空行隔开，注释与所描述内容进行同样的缩排
<pre><code>
/**
*这里是类注释
*/
public class Logger{
    /**
    *字段的注释
    */
    private String logType;
    /**
    *函数注释
    */
    public void write(){
    }
}
</code></pre>
* （3）函数的注释：公有和保护方法注释需要列出方法的一句话功能描述、功能详细描述、输入参数、输出参数、返回值、异常等。
<pre><code>
/**
*一句话功能描述
*功能详细描述
*@param［参数1］［参数1说明］
*@param［参数2］［参数2说明］
*@return［返回类型说明］
*@exception/throws［异常类型］［异常说明］
*@see ［相关类／方法］（可选）
*@since［产品／模块版本］
*@deprecated（可选）
*/
</code></pre>
* （4）异常的注释：对于方法内部用throw语句抛出的异常，必须在方法的注释中标明，对于所调用的其他方法所抛出的异常，选择主要的在注释中说明。对于非RuntimeException，即throws子句声明会抛出的异常，必须在方法的注释中标明。如：
<pre><code>
/**
 *关闭当前数据流
 * @throws IOException当关闭流失败时抛出该异常
*/
public void close() throws IOException{
    //相关代码
}
</code></pre>
## 命名
* (1)类名和接口使用类意义完整的英文描述，每个英文单词的首字母使用大写、其余字母使用小写的大小写混合法，也就是驼峰命名法。
* (2)函数命名：函数名使用类意义完整的英文描述：第一个单词的字母使用小写，剩余单词使用驼峰命名法。
* (3)setter()和getter()：方法中，存取属性的方法采用setter和getter方法，动词方法采用动词和动滨结构。格式为：
<pre><code>
get ＋ 非布尔属性名（）
is + 布尔属性名（）
set + 属性名()
动词（）
动词＋宾语（）
</code></pre>
* (4)字段名使用意义完整的英文描述，第一个单词的字母使用小写m（代表member），剩下的字母使用驼峰命名法。建议将字段设置为public，这样可以避免额外的setter和getter调用开销，如果字段为public，那么字段名将去掉m前缀，以小写字母开头。注意，属性名不能和方法名相同
* (5)常量名使用全大写的英文描述，英文单词之间用下划线分隔开，并且使用static final修饰。如果只是static而不是final，那么变量以s开头，后面以驼峰命名法进行命名。
## 编码建议
* (1)break语句：对于switch语句下的case语句，必须在每个case分支结束前加上break语句。至于语法上合法的场景“一个case后进入下一个case处理”，应该在编码设计上就避免。
* (2)覆写时添加@Override:对重载父类的方法必须进行@Override声明。这样可以清楚说明此方法是重载父类的方法，保证重载父类的方法时不会因为单词写错而导致错误。
* (3)指定集合中的元素类型：在使用List、Map等集合类型时必须指定元素类型。
* (4)显示指明操作符优先级：注意运算符的优先级，并且用括号明确表达式的操作顺序，避免使用默认优先级。推荐如下形式：
<pre><code>
（1）int result = (high<<8)|low;
（2）int result = (a|b)&&(a&c);
（2）int result = (a|b)<(c&d);
</code></pre>
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
<p>Activity范例</p>
<pre><code>
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
</code></pre>


   


