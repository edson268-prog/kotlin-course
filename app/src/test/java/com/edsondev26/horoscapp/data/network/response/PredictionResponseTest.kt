package com.edsondev26.horoscapp.data.network.response

import com.edsondev26.horoscapp.motherobject.HoroscopeMotherObject
import io.kotlintest.shouldBe
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import kotlin.math.sign

class PredictionResponseTest {
    @Test
    fun `toDomain should return a correct PredictionModel`() {
        // Given
        val horoscopeResponse = HoroscopeMotherObject.anyResponse
//        val horoscopeResponse = HoroscopeMotherObject.anyResponse.copy(sign = "libra")

        // When
        val predictionModel = horoscopeResponse.toDomain()
        // Then
        predictionModel.sign shouldBe  horoscopeResponse.sign
        predictionModel.horoscope shouldBe  horoscopeResponse.horoscope

    }
}