package com.edsondev26.horoscapp.ui.horoscope

import com.edsondev26.horoscapp.data.providers.HoroscopeProvider
import com.edsondev26.horoscapp.motherobject.HoroscopeMotherObject.horoscopeInfoList
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertTrue

class HoroscopeViewModelTest {
    @MockK
//    @MockK(relaxed = true) // Not good practice
    private lateinit var horoscopeProvider: HoroscopeProvider

    private lateinit var viewModel: HoroscopeViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `When viewmodel is created then horoscopes are loaded`() {
//        coEvery { horoscopeProvider.getHoroscopes()} returns listOf()  // coEvery for coroutines
        every { horoscopeProvider.getHoroscopes() } returns horoscopeInfoList
        viewModel = HoroscopeViewModel(horoscopeProvider)

        val horoscopes = viewModel.horoscope.value

        assertTrue(horoscopes.isNotEmpty())
//        verify {  }
//        assert(horoscopeProvider.getHoroscopes().forExactly())
    }
}