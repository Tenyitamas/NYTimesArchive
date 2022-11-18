package com.android.tenyitamas.nytimesarchive.domain.repository

import com.android.tenyitamas.nytimesarchive.domain.model.Article
import com.android.tenyitamas.nytimesarchive.util.Resource

interface ArchiveRepository {

    suspend fun getArchives(
        year: Int,
        month: Int
    ): Resource<List<Article>>
}