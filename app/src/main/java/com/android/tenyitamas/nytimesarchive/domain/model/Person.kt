package com.android.tenyitamas.nytimesarchive.domain.model

import com.google.gson.annotations.SerializedName

data class Person(
    @SerializedName("firstname")
    var firstName: String? = null,
    @SerializedName("middlename")
    var middleName: String? = null,
    @SerializedName("lastname")
    var lastName: String? = null,
    @SerializedName("qualifier")
    var qualifier: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("role")
    var role: String? = null,
    @SerializedName("organization")
    var organization: String? = null,
)
