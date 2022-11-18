package com.android.tenyitamas.nytimesarchive.data.remote

import com.android.tenyitamas.nytimesarchive.domain.model.Article
import com.google.gson.annotations.SerializedName

data class ArchiveResponse(
    @SerializedName("docs")
    var articles: ArrayList<Article> = arrayListOf(),
    @SerializedName("meta")
    var meta: Meta? = Meta()

) {
    data class Meta(
        @SerializedName("hits")
        var hits: Int? = null
    )
}
