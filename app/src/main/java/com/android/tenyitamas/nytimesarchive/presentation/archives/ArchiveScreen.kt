package com.android.tenyitamas.nytimesarchive.presentation.archives

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.tenyitamas.nytimesarchive.domain.model.Article

@Composable
fun ArchiveScreen(
    modifier: Modifier = Modifier,
    onItemClick: (Article) -> Unit,
    viewModel: ArchivesViewModel = hiltViewModel()
) {

    val state = viewModel.state

    Box(
        // TODO: - Put in local spacing
        modifier = modifier.padding(16.dp)
    ) {
        when(state) {
            is ArchiveState.Error -> {
                Text(
                    text = state.message,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            ArchiveState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.Blue
                )
            }
            is ArchiveState.Success -> {
                LazyColumn(
                    modifier = Modifier.matchParentSize().align(Alignment.TopCenter)
                ) {
                    items(state.articles) { article ->
                        Text(text = article.headline?.kicker ?: "")
                    }
                    print(state.articles.toString())
                }
            }
        }

    }

}