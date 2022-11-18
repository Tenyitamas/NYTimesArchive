package com.android.tenyitamas.nytimesarchive.presentation.archives

import com.android.tenyitamas.nytimesarchive.domain.model.Article

sealed class ArchiveState {
    object Loading: ArchiveState()
    data class Success(val articles: List<Article> = emptyList()): ArchiveState()
    data class Error(val message: String = ""): ArchiveState()
}
