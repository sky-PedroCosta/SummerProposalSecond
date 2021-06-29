package com.summerproposal.repository

import com.summerproposal.domain.model.PeacockData
import com.summerproposal.network.PeacockApi
import retrofit2.Response
import javax.inject.Inject

class PeacockRepositoryImpl @Inject constructor(
    private val peacockData : PeacockApi,
): PeacockDataRepository {

    override suspend fun getAll(): Response<PeacockData> {
        return peacockData.getData()
    }
}