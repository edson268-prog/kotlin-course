package com.edsondev26.horoscapp.data.network.response

import com.edsondev26.horoscapp.domain.model.PredictionModel
import com.google.gson.annotations.SerializedName

data class PredictionResponse(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("sign") val sign: String
){
    fun toDomain():PredictionModel{
        return PredictionModel(
            horoscope = horoscope,
//            sign = date + sign
            sign = sign
        )
    }
}