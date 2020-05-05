package com.lingdtkhe.domain.usecase

import com.lingdtkhe.domain.common.result.Either
import com.lingdtkhe.domain.entities.TvProgram
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito

/**
 * Some unit test example of use case
 */
class TvChannelSchedulesUCTest {

    @Test
    fun testUCScheduleNotEmpty() = runBlockingTest {
        val repository: TvSchedules = Mockito.mock(TvSchedules::class.java)
        val uc = TvChannelSchedulesUC(repository)
        Mockito.`when`(repository.getTvProgramSchedules())
            .thenReturn(Either.Right(listOf<TvProgram>(TvProgram(1, "test", "desc", "url"))))

        Assert.assertTrue(uc.getTvSchedules().isRight)
    }

    @Test
    fun testUCScheduleEmpty() = runBlockingTest {
        val repository: TvSchedules = Mockito.mock(TvSchedules::class.java)
        val uc = TvChannelSchedulesUC(repository)
        Mockito.`when`(repository.getTvProgramSchedules())
            .thenReturn(Either.Right(listOf<TvProgram>()))

        Assert.assertTrue(uc.getTvSchedules().isLeft)
    }
}