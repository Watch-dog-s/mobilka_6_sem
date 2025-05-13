package com.example.lab1.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchSettingViewModel: ViewModel() {
    private var vacancy= MutableLiveData<String>()

    fun get_vacancy():String?{return vacancy.value}
    fun update_vacancy(direction1:String){vacancy.value=direction1}


    private var searchHistory= MutableLiveData<Array<String>>()

}