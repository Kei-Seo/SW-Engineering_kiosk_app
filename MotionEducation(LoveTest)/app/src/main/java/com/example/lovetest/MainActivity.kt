package com.example.lovetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    //나중에 초기화를 해주겠다.
    override fun onCreate(savedInstanceState: Bundle?) {
        //자바의 main과 같은 존재 But 필요에 따라 여러번 가능
        //화면이 세로모드에서 가로모드로 전환 시 onCreate함수가 다시 호출된다.
        // 만약 전역변수를 설정하고 그 값을 유지하며 항상 사용해야 하는 경우라도
        // 화면이 세로모드에서 가로모드로 변경될 경우 전역변수에 설정한 값이 모두 초기화 된다.
        // 이런 경우 변경된 값을 유지하고 싶다면  savedInstanceState을 이용하는 것이 좋다.
        //
        //출처: https://doraeul.tistory.com/43 [도래울]
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //R클래스란? - 자동으로 생성되는 클래스로서 resource의 id가 배정되는 클래스이다.

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController


    }
}