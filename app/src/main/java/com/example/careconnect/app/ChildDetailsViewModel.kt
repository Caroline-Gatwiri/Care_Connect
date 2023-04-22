package com.example.careconnect.app

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.careconnect.data.ApiService
import com.example.careconnect.data.Child
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class ChildDetailsViewModel @Inject constructor(private val apiService: ApiService) : ViewModel(){
    var childResponse: MutableLiveData<List<Child>> = MutableLiveData(emptyList())
        private set

    fun getAllChildren(){
        viewModelScope.launch{
            try {
                childResponse.value = apiService.getAllChildren()
            } catch (e: java.lang.Exception){
                Timber.e("ERROR FETCHING!")
                Timber.e(e.localizedMessage)
            }
        }
    }
}