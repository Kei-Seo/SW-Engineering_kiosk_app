package com.example.lovetest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lovetest.R
import kotlinx.android.synthetic.main.fragment_result.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {

    var option : Int? = -1 //

    lateinit var navController: NavController

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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

        option = arguments?.getInt("index")?:-1
        //키 값 index로 보냈으니까
        //인ㅌ덱스로 잡아준다.

        return inflater.inflate(R.layout.fragment_result, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        setResult(option)
        //제목이랑 상세 결과를 바꿔야한다.

        btn_home.setOnClickListener {
            navController.navigate(R.id.action_resultFragment_to_mainFragment)
        }
    }

    private fun setResult(option: Int?) {
        when(option){
            1->{
                tv_main.text = "You are a QUITTER!" //쉽게 포기하는 사람!
                tv_sub.text = "You can let the person easily." // 너는 사람을 쉽게 놔버릴 수 있어
            }
            2->{
                tv_main.text = "You should focus on yourself" // 넌 너 자신에게 집중해야해
                tv_sub.text = "You become really clingy to your ex." // 전 애인에게 정말 집착하게 될거야
            }
            3->{
                tv_main.text = "You should take it easy" // 자제좀 하는게 좋을것 같아.
                tv_sub.text = "You can do crazy things on matter what it takes." // 넌 무엇이 필요하든 미친짓을 할 수 있어
            }
            4->{
                tv_main.text = "You are pretty mature" // 너 좀 성숙하구나?
                tv_sub.text = "You can easily accept the break-up" //결별을 쉽게 받아들일 수 있을거야
            }



        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ResultFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}