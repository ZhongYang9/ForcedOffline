package com.zhongyang.forcedoffline.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.zhongyang.forcedoffline.R
import com.zhongyang.forcedoffline.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    val tag = "MainActivity"

    override fun getSubView(): Int {
        return R.layout.activity_main
    }

    override fun initActivityEvent() {
        super.initActivityEvent()
        //强制下线按钮点击事件
        btn_forcedOffline.setOnClickListener {
            Log.d(tag,"强制下线...")
            //强制下线逻辑
            forceOfflineLogic()
        }
    }

    private fun forceOfflineLogic() {
        val intent = Intent("com.zhongyang.forcedoffline.FORCE_OFFLINE")//设置广播动作
        sendBroadcast(intent)//发送广播
    }
}