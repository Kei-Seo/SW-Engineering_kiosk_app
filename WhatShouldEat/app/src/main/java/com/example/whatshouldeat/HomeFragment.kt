package com.example.whatshouldeat

import android.content.Context
import android.os.Bundle
import android.util.Config
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.LocalFocusManager
import androidx.fragment.app.Fragment


class HomeFragment : Fragment() {

    companion object{
        const val TAG : String = "로그"

        fun newInstance() : HomeFragment { //자기 자신의 인스턴스를 가져와야함
            return HomeFragment()
        }
    }

    //fragment 가 화면에 올라갔을떄
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "HomeFragment - OnCreate() called")
    }

    // Fragment 를 안고 있는 activity 에 fragment 가 붙엇을떄
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "HomeFragment - OnAttach() called")
    }


    // 뷰가 생겼을때
    // Fragment 와 layout 을 연결해주는 부분
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "HomeFragment - OnAttach() called")

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        //container 는 view Group 이다.

        return view
    }

}