package com.example.locationtracking

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.*
import java.io.IOException

class CoroutineActivity : AppCompatActivity() {

    var htmlStr = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        coroutine()
    }

    fun coroutine(){
        //백그라운드 실행
        CoroutineScope(Dispatchers.Main).launch {

            var html = CoroutineScope(Dispatchers.Default).async {
                getHtmlStr()
            }.await()
            //main thread
            val mTextMain = findViewById<TextView>(R.id.mTextMain)
            mTextMain.text = htmlStr
        }

    }

     fun getHtml(): String{
         //1. 클라이언트를 만들기
         val client = OkHttpClient.Builder().build()
         //2. 요청
         val req = Request.Builder().url("https://www.google.com").build()
         //3.응답
         client.newCall(req).execute().use {
             //응답이 들어옴
             response -> return if(response.body != null){
                 response.body!!.string()
         }
             else{
             "body null"
         }
         }
    }

    fun getHtmlStr(){
        //1. 클라이언트를 만들기
        val client = OkHttpClient.Builder().build()
        //2. 요청
        val req = Request.Builder().url("https://www.google.com").build()
        //3.응답
        client.newCall(req).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
            }

            override fun onResponse(call: Call, response: Response) {
                CoroutineScope(Dispatchers.Main).launch {
                    val mTextMain = findViewById<TextView>(R.id.mTextMain)
                    mTextMain.text = response.body!!.string()
                }
            }

        })


    }
}