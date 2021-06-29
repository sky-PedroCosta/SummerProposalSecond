package com.summerproposal.ui

import com.summerproposal.repository.PeacockRepositoryImpl
import io.mockk.mockk
import org.junit.After
import org.junit.Before
import org.junit.Test

internal class MainViewModelTest {

    private lateinit var mockViewModel: MainViewModel
    private var repository = mockk<PeacockRepositoryImpl>()


    @Before
    fun setUp() {
        mockViewModel = MainViewModel(repository)
    }


    @Test
    fun `start_In Loading`(){
        mockViewModel.fetchData()
    }

    @After
    fun tearDown() {

    }

}