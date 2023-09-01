package com.example.appticmascurso

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.appticmascurso.model.ComparissonText

class MainViewModel: ViewModel() {

    val comparissonTextModel: MutableLiveData<ComparissonText> get() = _comparissonText

    private var _comparissonText = MutableLiveData<ComparissonText>(ComparissonText(" "))

    fun comparissonTextFun(firstText: String,secondText: String ){
        if (firstText == secondText){
            updateComparisson("Los textos coinciden")
        };
        else{
            updateComparisson("Los textos no coinciden")
        }
    }

    private fun updateComparisson(comparisonResult: String) {
        viewModelScope.launch {
            _comparissonText.value = ComparissonText(comparisonResult)
        }
    }
}

