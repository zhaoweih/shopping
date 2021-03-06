package me.zhaoweihao.shopping

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_user.*
import me.zhaoweihao.shopping.constant.Constant.baseUrl
import me.zhaoweihao.shopping.goods.CollectionActivity
import me.zhaoweihao.shopping.goods.MyGoodsActivity
import me.zhaoweihao.shopping.goods.PublishGoodsActivity
import me.zhaoweihao.shopping.database.UserInfo
import me.zhaoweihao.shopping.message.NotificationActivity
import me.zhaoweihao.shopping.trade.PurchaserTradeActivity
import me.zhaoweihao.shopping.trade.SellerTradeActivity
import me.zhaoweihao.shopping.ui.LoginActivity
import me.zhaoweihao.shopping.ui.SettingActivity
import me.zhaoweihao.shopping.user.AuthenticateActivity
import me.zhaoweihao.shopping.user.ConcernActivity
import me.zhaoweihao.shopping.user.UpdateUserInfoActivity
import org.litepal.crud.DataSupport

/**
 * Created by Administrator on 2018/2/8.
 */
class UserFragment : Fragment() {

    val TAG = "UserFragment"

    companion object {

        fun newInstance(): UserFragment {
            return UserFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView")
        return inflater!!.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_login.setOnClickListener {
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
        }
        iv_user_collect.setOnClickListener {
            val intent = Intent(activity, CollectionActivity::class.java)
            startActivity(intent)
        }
        iv_user_concern.setOnClickListener {
            val intent = Intent(activity, ConcernActivity::class.java)
            startActivity(intent)
        }
        iv_user_trade_purchaser.setOnClickListener {
            val intent = Intent(activity, PurchaserTradeActivity::class.java)
            startActivity(intent)
        }
        iv_user_trade_seller.setOnClickListener {
            val intent = Intent(activity, SellerTradeActivity::class.java)
            startActivity(intent)
        }
        iv_avatar.setOnClickListener {
            val intent = Intent(activity, UpdateUserInfoActivity::class.java)
            startActivity(intent)
        }
        iv_publish_goods.setOnClickListener {
            val intent = Intent(activity, PublishGoodsActivity::class.java)
            startActivity(intent)
        }
        iv_my_goods.setOnClickListener {
            val intent = Intent(activity, MyGoodsActivity::class.java)
            startActivity(intent)
        }
        iv_notification.setOnClickListener {
            val intent = Intent(activity, NotificationActivity::class.java)
            startActivity(intent)
        }
        tv_setting.setOnClickListener {
            val intent = Intent(activity, SettingActivity::class.java)
            startActivity(intent)
        }
    }

    private fun hideOrShowComponents(code: Int) {
        iv_avatar.visibility = code
        imageView3.visibility = code
        tv_usercoin.visibility = code
        tv_userauthenticated.visibility = code
        tv_phone.visibility = code
        tv_location.visibility = code
        tv_username.visibility = code
        tv_setting.visibility = code
        imageButton2.visibility = code
        textView7.visibility = code
        textView9.visibility = code
        textView11.visibility = code
        iv_publish_goods.visibility = code
        textView13.visibility = code
        iv_user_trade_purchaser.visibility = code
        textView14.visibility = code
        iv_user_collect.visibility = code
        textView15.visibility = code
        view1.visibility = code
        iv_my_goods.visibility = code
        textView16.visibility = code
        imageView8.visibility = code
        textView17.visibility = code
        iv_notification.visibility = code
        textView18.visibility = code
        imageView10.visibility = code
        textView19.visibility = code
        imageView11.visibility = code
        textView20.visibility = code
        iv_user_trade_seller.visibility = code
        iv_user_concern.visibility = code
        textView6.visibility = code
        textView8.visibility = code
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
        val find = DataSupport.findFirst(UserInfo::class.java)
        if (find != null) {

            tv_username.text = find.userName
            Log.d(TAG, find.userName)
            val location = find.userAddressMore
            if (location == "未填写") {
                tv_location.text = "点此填写地址"
                tv_location.setOnClickListener {
                    //这里进行填写地址
                }
            } else {
                tv_location.text = location
            }
            tv_phone.text = find.userPhone
            tv_usercoin.text = find.userCoin.toString()
            val imageUrl = find.userAvator
            Picasso.with(activity).load(baseUrl + imageUrl)
                    .resize(100, 100)
                    .centerCrop()
                    .into(iv_avatar)
            if (find.userAuthenticated == 1) {
                tv_userauthenticated.text = "已实名"
            } else {
                tv_userauthenticated.text = "点此实名"
                tv_userauthenticated.setOnClickListener {
                    //这里进行实名操作
                    val intent = Intent(activity, AuthenticateActivity::class.java)
                    startActivity(intent)
                }
            }
            hideOrShowComponents(View.VISIBLE)
            tv_not_login.visibility = View.INVISIBLE
            btn_login.visibility = View.INVISIBLE
        } else {
            Log.d(TAG, "bad")
            hideOrShowComponents(View.INVISIBLE)
            tv_not_login.visibility = View.VISIBLE
            btn_login.visibility = View.VISIBLE
        }


    }

}