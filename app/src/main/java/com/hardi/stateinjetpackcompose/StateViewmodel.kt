package com.hardi.stateinjetpackcompose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StateViewmodel : ViewModel() {

    private val _name = MutableLiveData<String>()
    private val _surname = MutableLiveData<String>()

    val name: LiveData<String> = _name
    val surname: LiveData<String> = _surname

    fun changeName(newName: String) {
        _name.value = newName
    }

    fun changeSurName(newSurName: String) {
        _surname.value = newSurName
    }

}