package com.example.myapplication

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.constance.Constance
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
lateinit var bindingClass : ActivityMainBinding
    private var nameCheck:String ="empty"
    private var name2Check:String ="empty"
    private var loginCheck:String ="empty"
    private var passwordCheck:String ="empty"
    private var img :Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass= ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }


    fun onClickIn(view: View){
        val send=Intent(this, SecondActivity::class.java)
        send.putExtra(Constance.SIGN_STATE, Constance.SIGN_IN_STATE)
        startActivityForResult(send,Constance.REQUEST_CODE_IN)
    }

    fun onClickUp(view: View){
        val send=Intent(this, SecondActivity::class.java)
        send.putExtra(Constance.SIGN_STATE, Constance.SIGN_UP_STATE)
        startActivityForResult(send,Constance.REQUEST_CODE_UP)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==Constance.REQUEST_CODE_IN){
            val login = data?.getStringExtra(Constance.LOGIN)
            val password = data?.getStringExtra(Constance.PASSWORD)
            if(login==loginCheck&&password==passwordCheck)
            {
                bindingClass.imageView2.visibility=View.VISIBLE
                bindingClass.imageView2.setImageResource(img)
                bindingClass.answer.visibility=View.VISIBLE
                val namefull ="$nameCheck $name2Check"
                bindingClass.answer.text=namefull

                bindingClass.signUp.visibility=View.INVISIBLE
                bindingClass.signIn.text="Exit"
            }
            else {bindingClass.answer.text="error"}
        }
        else if(requestCode==Constance.REQUEST_CODE_UP){

            loginCheck = data?.getStringExtra(Constance.LOGIN)!!
            passwordCheck = data.getStringExtra(Constance.PASSWORD)!!
            nameCheck = data.getStringExtra(Constance.NAME)!!
            name2Check = data.getStringExtra(Constance.SECONDNAME)!!

            bindingClass.imageView2.visibility=View.VISIBLE
            img =data.getIntExtra(Constance.IMG, 0)!!
            bindingClass.imageView2.setImageResource(img)
            val namefull="$nameCheck $name2Check"
            bindingClass.answer.visibility=View.VISIBLE
            bindingClass.answer.text=namefull
            bindingClass.signUp.visibility=View.INVISIBLE
            bindingClass.signIn.text="Exit"

        }
        else {
            bindingClass.answer.visibility = View.VISIBLE
            bindingClass.answer.text = "you loh"
        }
    }

}