package com.example.lovetest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.lovetest.R
import kotlinx.android.synthetic.main.fragment_main.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //view가 만들어지고 나서 호출이 되는 함수

        //대상으로 이동하는 것은 NavController 객체를 사용하여 실행되며 이 객체는 NavHost 내에서 앱 탐색을 관리합니다.
        // 각 NavHost에는 그에 상응하는 자체 NavController가 있습니다. NavController를 사용하면 몇 가지 방식으로 대상으로 이동

        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        //대상으로 이동하는 것은 NavController 객체를 사용하여 실행되며 이 객체는 NavHost 내에서 앱 탐색을 관리합니다.
        // 각 NavHost에는 그에 상응하는 자체 NavController가 있습니다. NavController를 사용하면 몇 가지 방식으로 대상으로 이동
        btn_next.setOnClickListener{
            navController.navigate(R.id.action_mainFragment_to_questionFragment)
            /*
            apply plugin: 'com.android.application'
            apply plugin: 'kotlin-android'
            apply plugin: 'kotlin-android-extensions'
            버튼을 눌렀을때 다음 페이지로 넘어간다.
             */
        }



    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}