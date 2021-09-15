package com.example.whatshouldeat

import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.content.pm.Signature
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class MainActivity : AppCompatActivity() {

    // member 변수

    private lateinit var homeFragment: HomeFragment
    private lateinit var cookFragment: CookFragment
    private lateinit var myPageFragment : MyPageFragment


    companion object{

        const val TAG: String = "로그"
    }

    //화면이 메모리에 올라갔을 떄
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val mapView = net.daum.mf.map.api.MapView(this)
//        val mapViewContainer = map_view
//        mapViewContainer.addView(mapView)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        Log.d(TAG, "MainActivity - OnCreate() called!")

        bottom_nav.setOnNavigationItemSelectedListener(onBottomNavItemSelectedListener)

        homeFragment = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.fragments_frame, homeFragment).commit()
        // 초기화면에는 home fragment 가 나오도록 add


        //메인 화면에서 다음 재료추가 화면으로 이동동
       btn_ingredient.setOnClickListener {
            val nextIntent = Intent(this, IngredientActivity::class.java)
            startActivity(nextIntent)
        }


    }




    private val onBottomNavItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener{
        when(it.itemId){
            R.id.menu_home ->{
                Log.d(TAG, "홈버튼 클릭")
                homeFragment = HomeFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, homeFragment).commit()
                //fragment_frame 안에 변경되는 지점 설정
            }

            R.id.menu_cook -> {
                Log.d(TAG, "요리 버튼 클릭")
                cookFragment = CookFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, cookFragment).commit()
                //fragment_frame 안에 변경되는 지점 설정
            }

            R.id.menu_myInfo -> {
                Log.d(TAG, "내정보 버튼 클릭")
                myPageFragment = MyPageFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, myPageFragment).commit()
                //fragment_frame 안에 변경되는 지점 설정
            }
        }
        true
    }

//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        Log.d(TAG, "MainActivity - onNavigationSelected() called")
//
//        when(item.itemId){
//            R.id.menu_home ->{
//                Log.d(TAG, "홈버튼 클릭")
//            }
//
//            R.id.menu_cook -> {
//                Log.d(TAG, "요리 버튼 클릭")
//            }
//
//            R.id.menu_myInfo -> {
//                Log.d(TAG, "내정보 버튼 클릭")
//            }
//        }
//
//        return true
//    }
}