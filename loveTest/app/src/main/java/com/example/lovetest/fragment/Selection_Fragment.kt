package com.example.lovetest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lovetest.R
import kotlinx.android.synthetic.main.fragment_selection_.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Selection_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Selection_Fragment : Fragment() , View.OnClickListener {
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

    lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btn_back.setOnClickListener(this)
        option_1.setOnClickListener(this)
        option_2.setOnClickListener(this)
        option_3.setOnClickListener(this)
        option_4.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        //v? null일 수도 있기 때문에  safe하게 사용하기 위해
        //뷰가 눌이 아니면 id를 가져오고 눌이면 전체는 눌을 반환
        when(p0?.id){
            R.id.option_1 -> {navigatewithindex(1)}
            R.id.option_2 -> {navigatewithindex(2)}
            R.id.option_3 -> {navigatewithindex(3)}
            R.id.option_4 -> {navigatewithindex(4)}
            R.id.btn_back -> {
                navController.popBackStack()
                //뷰는 스택에 쌓인다 그래서 가장 위에 있는걸 팝 해주면됨
            }

        }
    }

    fun navigatewithindex(index : Int){
        val bundle = bundleOf("index" to index)
        //Bundle은 여러가지의 타입의 값을 저장하는 Map 클래스이다.
        //즉, Bundle은 아무거나 포장할 수 있는 상자를 의미하고 이 포장 박스를 이용하여 이리저리 인텐트도 오고갈 수 있고,
        //
        //다양한 데이터 통신에 이용 할 수 있다.

        navController.navigate(R.id.action_selection_Fragment_to_resultFragment, bundle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selection_, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Selection_Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Selection_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}