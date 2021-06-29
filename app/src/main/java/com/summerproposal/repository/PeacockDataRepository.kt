package com.summerproposal.repository

import com.summerproposal.domain.model.PeacockData
import retrofit2.Response

interface PeacockDataRepository {

    suspend fun getAll() : Response<PeacockData>
}