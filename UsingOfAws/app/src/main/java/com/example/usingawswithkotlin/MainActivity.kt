package com.example.usingawswithkotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.usingawswithkotlin.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_note.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var text = "Hello!"
    //var lateinit toolbar : Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(toolbar)

        // prepare our List view and RecyclerView (cells)
        setupRecyclerView(item_list)
        /* binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
         binding.main = this

         binding.btnChange.setOnClickListener {
             Toast.makeText(this, "작동하나요?", Toast.LENGTH_SHORT).show()
             text = "hello asa!"

             binding.invalidateAll()*/
        //모든 바인딩을 표현은 무효화하고, 새로운 바인딩 UI 요청을 시도합니다.
    }
    private fun setupRecyclerView(recyclerView: RecyclerView) {

        // update individual cell when the Note data are modified
        UserData.notes().observe(this, Observer<MutableList<UserData.Note>> { notes ->
            Log.d(TAG, "Note observer received ${notes.size} notes")

            // let's create a RecyclerViewAdapter that manages the individual cells
            recyclerView.adapter = NoteRecyclerViewAdapter(notes)
        })
    }

        // update individual cell when the Note data are modified


    companion object {
        private const val TAG = "MainActivity"
    }


}
