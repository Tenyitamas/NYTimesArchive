package com.android.tenyitamas.nytimesarchive.data.remote

import com.android.tenyitamas.nytimesarchive.BuildConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArchiveApi {

    @GET("{year}/{month}.json")
    suspend fun getArchives(
        @Path("year")
        year: Int,
        @Path("month")
        month: Int,
        @Query("api-key")
        apiKey: String = BuildConfig.NYTIMES_API_KEY
    ) : Response<ArchiveResponse>
}