package com.zhongyang.forcedoffline.utils

import android.app.Activity

/**
 * @项目名称 ForcedOffline
 * @类名 ActivityCollector
 * @包名 com.zhongyang.forcedoffline.utils
 * @创建时间 2021/1/13 11:14
 * @作者 钟阳
 * @描述 管理Activity的单例类
 */
object ActivityCollector {

    //定义一个集合用于保存Activity，泛型指定为Activity类
    private val mActivities = ArrayList<Activity>()

    /**
     * 添加Activity方法
     */
    fun addActivity(activity: Activity) {
        mActivities.add(activity)
    }

    /**
     * 移除Activity方法
     */
    fun removeActivity(activity: Activity) {
        mActivities.remove(activity)
    }

    /**
     * 结束所有Activity方法
     */
    fun finishAll() {
        //遍历mActivities集合
        for (activity in mActivities) {
            if (!activity.isFinishing) {
                //当该Activity不在关闭状态时，就关闭该Activity
                activity.finish()
            }
        }
        //清除集合
        mActivities.clear()
    }
}