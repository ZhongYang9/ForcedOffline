package com.zhongyang.forcedoffline.base

import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zhongyang.forcedoffline.broadcast.ForceOfflineReceiver
import com.zhongyang.forcedoffline.utils.ActivityCollector

/**
 * @项目名称 ForcedOffline
 * @类名 BaseActivity
 * @包名 com.zhongyang.forcedoffline.base
 * @创建时间 2021/1/13 11:21
 * @作者 钟阳
 * @描述
 */
abstract class BaseActivity : AppCompatActivity() {

    lateinit var mForceOfflineReceiver: ForceOfflineReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*将当前Activity添加到管理栈中*/
        ActivityCollector.addActivity(this)
        /*子类加载布局*/
        setContentView(getSubView())
        /*初始化活动事件*/
        initActivityEvent()
    }

    protected open fun initActivityEvent() {
        //子类活动的监听事件，由子类根据情况复写
    }

    abstract fun getSubView(): Int

    override fun onDestroy() {
        super.onDestroy()
        /*将当前Activity移出管理栈*/
        ActivityCollector.removeActivity(this)
    }

    override fun onResume() {
        super.onResume()
        //动态注册广播
        val intentFilter = IntentFilter()
        intentFilter.addAction("com.zhongyang.forcedoffline.FORCE_OFFLINE")
        mForceOfflineReceiver = ForceOfflineReceiver()
        registerReceiver(mForceOfflineReceiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        //取消注册
        unregisterReceiver(mForceOfflineReceiver)
    }
}