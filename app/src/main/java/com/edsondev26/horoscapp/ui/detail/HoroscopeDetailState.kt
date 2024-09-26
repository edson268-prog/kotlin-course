package com.edsondev26.horoscapp.ui.detail

import com.edsondev26.horoscapp.domain.model.HoroscopeModel

sealed class HoroscopeDetailState {
    data object Loading:HoroscopeDetailState() // With params
    data class Error(val error:String):HoroscopeDetailState() // Without params
    data class Success(val prediction:String, val sign:String, val horoscopeModel: HoroscopeModel):HoroscopeDetailState()
}