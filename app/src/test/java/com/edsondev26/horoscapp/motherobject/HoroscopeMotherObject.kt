package com.edsondev26.horoscapp.motherobject

import com.edsondev26.horoscapp.data.network.response.PredictionResponse
import com.edsondev26.horoscapp.domain.model.HoroscopeInfo.*

object HoroscopeMotherObject {
    val anyResponse = PredictionResponse("date", "prediction", "taurus")

    val horoscopeInfoList = listOf(
        Aries,
        Taurus,
        Gemini,
        Cancer,
        Leo,
        Virgo,
        Libra,
        Scorpio,
        Sagittarius,
        Capricorn,
        Aquarius,
        Pisces
    )
}