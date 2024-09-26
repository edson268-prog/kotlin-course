package com.edsondev26.horoscapp.domain.model

import com.edsondev26.horoscapp.data.network.response.PredictionResponse

interface Repository {
    suspend fun getPrediction(sign: String): PredictionModel?
}