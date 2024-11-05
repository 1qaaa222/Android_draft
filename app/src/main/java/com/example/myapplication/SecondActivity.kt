package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.myapplication.constance.Constance
import com.example.myapplication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity(){
lateinit var bindingClass: ActivitySecondBinding
    private var message="empty"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        message =intent.getStringExtra((Constance.SIGN_STATE))!!
        if(message==Constance.SIGN_IN_STATE) {
            bindingClass.firstName.visibility=View.GONE
            bindingClass.secondName.visibility=View.GONE
            bindingClass.ava.visibility=View.INVISIBLE
            //bindingClass.imageView3.visibility=View.INVISIBLE
        }

    }

    fun onClickBack(view: View) {
    if (message == Constance.SIGN_UP_STATE) {

        val intent1 = Intent()
        intent1.putExtra(Constance.NAME, bindingClass.firstName.text.toString())////////////////////////забыла text
        intent1.putExtra(Constance.SECONDNAME, bindingClass.secondName.text.toString())
        intent1.putExtra(Constance.LOGIN, bindingClass.login.text.toString())
        intent1.putExtra(Constance.PASSWORD, bindingClass.password.text.toString())
        if (bindingClass.imageView3.isVisible) {
            intent1.putExtra(Constance.IMG, R.drawable.dog)
        }
        setResult(RESULT_OK, intent1)
        finish()
    } else if (message == Constance.SIGN_IN_STATE) {
        val intent2 = Intent()
        intent2.putExtra(Constance.LOGIN, bindingClass.login.toString())
        intent2.putExtra(Constance.PASSWORD, bindingClass.password.toString())
        setResult(RESULT_OK, intent2)
        finish()
    }

}
    fun onClickAva(view: View) {
        bindingClass.imageView3.visibility = View.VISIBLE

    }
}