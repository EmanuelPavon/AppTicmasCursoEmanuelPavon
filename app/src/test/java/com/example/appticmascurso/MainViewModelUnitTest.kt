package com.example.appticmascurso

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.appticmascurso.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckInitialValue() = runTest {
        val value = viewModel.comparissonTextModel.value?.string
        assertEquals(" ", value)
    }

    @Test
    fun mainViewModel_TestComparissonTextFunEquals() = runTest {
        launch {
            viewModel.comparissonTextFun("","")
        }
        advanceUntilIdle()
        val value = viewModel.comparissonTextModel.value?.string
        assertEquals("Coinciden", value)
    }
}