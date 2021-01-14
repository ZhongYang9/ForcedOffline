package com.zhongyang.forcedoffline.broadcast

import android.app.AlertDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.zhongyang.forcedoffline.activities.LoginActivity
import com.zhongyang.forcedoffline.utils.ActivityCollector

/**
 * @项目名称 ForcedOffline
 * @类名 ForceOfflineReceiver
 * @包名 com.zhongyang.forcedoffline.broadcast
 * @创建时间 2021/1/13 12:22
 * @作者 钟阳
 * @描述
 */
class ForceOfflineReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        //弹出对话框
        AlertDialog.Builder(context).apply {
            setTitle("提示")
            setMessage("你已被强制下线，请重新登录")
            setCancelable(false)
            setPositiveButton("确定") { dialog, which ->
                //销毁所有活动
                ActivityCollector.finishAll()
                //跳转到登录界面
                val i = Intent(context, LoginActivity::class.java)
                context?.startActivity(i)
            }
            show()
        }
    }
}