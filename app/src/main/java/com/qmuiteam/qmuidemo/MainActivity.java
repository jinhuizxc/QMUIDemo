package com.qmuiteam.qmuidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 提高 Android UI 开发效率的 UI 库 http://qmuiteam.com/android
 * https://github.com/Tencent/QMUI_Android
 *
 *
 qmui
 1. 引入库
 最新的库会上传到 JCenter 仓库上，请确保配置了 JCenter 仓库源，然后直接引用：
 implementation 'com.qmuiteam:qmui:1.2.0'
 至此，QMUI 已被引入项目中。

 2. 配置主题
 把项目的 theme 的 parent 指向 QMUI.Compat，至此，QMUI 可以正常工作。

 3. 覆盖组件的默认表现
 你可以通过在项目中的 theme 中用 <item name="(name)">(value)</item> 的形式来覆盖 QMUI 组件的默认表现。
 具体可指定的属性名请参考 @style/QMUI.Compat 中的属性。


 arch
 1. 引入库
 arch 库会依赖 qmui 库， 因此也需要引入 qmui 库
 implementation com.qmuiteam:arch:0.3.1
 2. 在 Application#onCreate 中初始化
 QMUISwipeBackActivityManager.init(this);

 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
