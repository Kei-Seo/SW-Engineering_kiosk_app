package com.example.usingawswithkotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestLiveDataViewModel : ViewModel() {
    val textView : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}