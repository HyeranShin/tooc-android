package com.hyeran.android.travely_user.mypage

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyeran.android.travely_user.R
import com.hyeran.android.travely_user.SplashActivity
import kotlinx.android.synthetic.main.fragment_profile.*
import org.jetbrains.anko.support.v4.startActivity

class ProfileFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_profile, container, false)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setClickListener()
    }

    private fun setClickListener() {
        btn_logout_profile.setOnClickListener {
            SharedPreferencesController.instance!!.removeAllData(this!!.context!!)

            val intent = Intent(activity, SplashActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

            startActivity(intent)
        }

        iv_modification_profile.setOnClickListener {
            iv_modification_profile.visibility = View.GONE
            tv_confilm_profile.visibility = View.VISIBLE
            et_name_profile.isFocusableInTouchMode = true
            et_email_profile.isFocusableInTouchMode = true
            et_password_profile.isFocusableInTouchMode = true
            et_password_confirm_profile.isFocusableInTouchMode = true
        }

        tv_confilm_profile.setOnClickListener {

            et_name_profile.setText(et_name_profile.text)

            iv_modification_profile.visibility = View.VISIBLE
            tv_confilm_profile.visibility = View.GONE
            et_name_profile.isFocusableInTouchMode = false
            et_email_profile.isFocusableInTouchMode = false
            et_password_profile.isFocusableInTouchMode = false
            et_password_confirm_profile.isFocusableInTouchMode = false

        }
    }

}