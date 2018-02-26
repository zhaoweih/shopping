package me.zhaoweihao.shopping

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_login.*
import me.zhaoweihao.shopping.gson.Login
import me.zhaoweihao.shopping.utils.HttpUtil
import me.zhaoweihao.shopping.utils.Utility
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

class LoginActivity : AppCompatActivity() {

    val TAG = "LoginActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_btn.setOnClickListener {
            val username = et_username.text.toString()
            val password = et_password.text.toString()

            val url = "http://meidai.maocanhua.cn/login"

            val login = Login()

            login.phone = username
            login.password = password

            val jsonObject = Gson().toJson(login)

            Log.d(TAG, jsonObject)

            HttpUtil.sendOkHttpPostRequest(url, jsonObject, object : Callback {
                override fun onFailure(call: Call, e: IOException) {

                }

                @Throws(IOException::class)
                override fun onResponse(call: Call, response: Response) {
                    val responseData = response.body()!!.string()
                    Log.d(TAG, responseData)
                    val user = Utility.handleUserResponse(responseData)
                    if (user!!.code == 200) {
                        Log.d(TAG, user.userData!!.userInfo!!.userPhone)
                    } else {
                        Log.d(TAG, "failed")
                    }
                }
            })
        }
    }
}