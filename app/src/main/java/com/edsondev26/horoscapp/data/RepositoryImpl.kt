package com.edsondev26.horoscapp.data

import android.util.Log
import com.edsondev26.horoscapp.data.network.HoroscopeApiService
import com.edsondev26.horoscapp.data.network.response.PredictionResponse
import com.edsondev26.horoscapp.domain.model.PredictionModel
import com.edsondev26.horoscapp.domain.model.Repository
import retrofit2.Retrofit
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService): Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("edsondev26", "An error as occurred ${it.message}")  }
        return null
    }
}