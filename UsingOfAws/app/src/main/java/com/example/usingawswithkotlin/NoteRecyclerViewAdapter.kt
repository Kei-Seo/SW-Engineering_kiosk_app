package com.example.usingawswithkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//노트를 나타내는 셀의 구성 요소 레이아웃을 설명하는 레이아웃 xml 파일. 이미지, 노트 제목 및 노트 설명을 표시합니다.
//지원 Kotlin 클래스. 생성 시 Note 데이터 객체를 수신하고 해당 보기(이미지, 제목 및 설명)에 개별 값을 할당합니다.
// this is a single cell (row) in the list of Notes
class NoteRecyclerViewAdapter(
    private val values: MutableList<UserData.Note>?) :
    RecyclerView.Adapter<NoteRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.content_note, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = values?.get(position)
        holder.nameView.text = item?.name
        holder.descriptionView.text = item?.description

        if (item?.image != null) {
            holder.imageView.setImageBitmap(item.image)
        }
    }

    override fun getItemCount() = values?.size ?: 0

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.image)
        val nameView: TextView = view.findViewById(R.id.name)
        val descriptionView: TextView = view.findViewById(R.id.description)
    }
}