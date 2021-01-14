package com.zhongyang.forcedoffline.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.zhongyang.forcedoffline.R
import com.zhongyang.forcedoffline.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    override fun getSubView(): Int {
        return R.layout.activity_login
    }

    override fun initActivityEvent() {
        super.initActivityEvent()
        //登录按钮点击事件
        btn_login.setOnClickListener {
            //登录逻辑
            loginLogic()
        }
    }

    private fun loginLogic() {
        //获取输入框内容
        val account = et_account.text.toString()
        val password = et_pwd.text.toString()
        //校验账号的合法性
        if (account.isEmpty() || password.isEmpty()) {
            //若有一个输入框为空
            Toast.makeText(this, "请输入完整信息", Toast.LENGTH_SHORT).show()
        } else if (account == "abc" && password == "123456") {
            //账号密码正确，就跳转结束当前活动
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            //账号密码错误
            Toast.makeText(this, "信息错误", Toast.LENGTH_SHORT).show()
        }
    }
}