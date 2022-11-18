package com.android.tenyitamas.nytimesarchive.data.repository

import com.android.tenyitamas.nytimesarchive.data.remote.ArchiveApi
import com.android.tenyitamas.nytimesarchive.domain.model.Article
import com.android.tenyitamas.nytimesarchive.domain.repository.ArchiveRepository
import com.android.tenyitamas.nytimesarchive.util.Resource
import javax.inject.Inject

class ArchiveRepositoryImpl @Inject constructor(
    private val api: ArchiveApi
): ArchiveRepository{
    override suspend fun getArchives(year: Int, month: Int): Resource<List<Article>> {
        return try {
            val response = api.getArchives(
                year = year,
                month = month
            )
            val result = response.body()
            if(response.isSuccessful && result != null) {
                Resource.Success(result.articles)
            } else {
                Resource.Error("Error while searching for archives")
            }


        } catch (e: Exception) {
            Resource.Error("Error occured: ${e.localizedMessage}")
        }
    }

}