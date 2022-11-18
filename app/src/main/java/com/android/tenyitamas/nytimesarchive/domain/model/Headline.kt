package com.android.tenyitamas.nytimesarchive.domain.model

import com.google.gson.annotations.SerializedName

data class Headline(
    @SerializedName("main")
    var main: String? = null,
    @SerializedName("kicker")
    var kicker: String? = null,
    @SerializedName("content_kicker")
    var contentKicker: String? = null,
    @SerializedName("print_headline")
    var printHeadline: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("seo")
    var seo: String? = null,
    @SerializedName("sub")
    var sub: String? = null
)
