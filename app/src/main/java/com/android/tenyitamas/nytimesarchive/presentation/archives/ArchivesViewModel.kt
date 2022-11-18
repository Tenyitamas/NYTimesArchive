package com.android.tenyitamas.nytimesarchive.presentation.archives

import android.icu.util.Calendar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.tenyitamas.nytimesarchive.domain.use_case.GetArchives
import com.android.tenyitamas.nytimesarchive.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ArchivesViewModel @Inject constructor(
    private val getArchives: GetArchives
) : ViewModel() {

    var state by mutableStateOf<ArchiveState>(ArchiveState.Loading)
        private set

    init {
        viewModelScope.launch {
            refreshArchives()
        }
    }


    private suspend fun refreshArchives() = withContext(Dispatchers.IO){
        viewModelScope.launch {
            state = ArchiveState.Loading
            val c = Calendar.getInstance()
            state = when(val res = getArchives(c.get(Calendar.YEAR), c.get(Calendar.MONTH))) {
                is Resource.Error -> {
                    ArchiveState.Error(res.message ?: "Unknown error")
                }
                is Resource.Loading -> {
                    ArchiveState.Loading
                }
                is Resource.Success -> {
                    ArchiveState.Success(
                        articles = res.data ?: emptyList()
                    )
                }
            }
        }
    }
}