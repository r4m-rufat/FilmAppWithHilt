package com.codingwithrufat.dihilt.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithrufat.dihilt.helper.Constants.TAG
import com.codingwithrufat.dihilt.models.ResponseItem
import com.codingwithrufat.dihilt.repository.GetAllDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel
@Inject
constructor(private val repository: GetAllDataRepository): ViewModel(){

    private val data = MutableLiveData<List<ResponseItem?>?>()

    val response: LiveData<List<ResponseItem?>?>
    get() = data

    init {

        getAllTvShows()

    }

    private fun getAllTvShows() = viewModelScope.launch {

        repository.getTVShows().let {
            if (it.isSuccessful){
                data.postValue(it.body()?.results)
            }else{
                Log.d(TAG, "getAllTvShows: ${it.errorBody()}")
            }
        }

    }

}