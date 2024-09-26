package com.edsondev26.horoscapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edsondev26.horoscapp.domain.model.HoroscopeModel
import com.edsondev26.horoscapp.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase) :
    ViewModel() {
    private var _horoscopeDetailState =
        MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val horoscopeDetailState: StateFlow<HoroscopeDetailState> = _horoscopeDetailState

    lateinit var horoscope:HoroscopeModel

    fun getHoroscope(sign: HoroscopeModel) {
        horoscope = sign
        viewModelScope.launch {
            // Main thread
            _horoscopeDetailState.value = HoroscopeDetailState.Loading
            val result = withContext(Dispatchers.IO) { getPredictionUseCase(sign.name) } // Secondary thread
            // Main thread
            if (result!= null){
                _horoscopeDetailState.value = HoroscopeDetailState.Success(result.horoscope, result.sign, horoscope)
            } else {
                _horoscopeDetailState.value = HoroscopeDetailState.Error("An error as occurred")
            }
        }
    }
}