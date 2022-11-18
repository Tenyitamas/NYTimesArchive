package com.android.tenyitamas.nytimesarchive.domain.use_case

import com.android.tenyitamas.nytimesarchive.domain.model.Article
import com.android.tenyitamas.nytimesarchive.domain.repository.ArchiveRepository
import com.android.tenyitamas.nytimesarchive.util.Resource

class GetArchives(
    private val repository: ArchiveRepository
) {
    suspend operator fun invoke(year: Int, month: Int): Resource<List<Article>> {
        return repository.getArchives(year, month)
    }
}