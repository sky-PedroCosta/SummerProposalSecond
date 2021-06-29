package com.summerproposal.domain.model

import com.google.gson.annotations.SerializedName

data class PeacockData(
    @SerializedName("id")
    var id: String,
    @SerializedName("relationships")
    var relationships: Relationship
)

data class Relationship(
    @SerializedName("items")
    var items: Items
)

data class Items(
    @SerializedName("data")
    var items: List<Data>
)

data class Data(
    @SerializedName("id")
    var id: String,
    @SerializedName("attributes")
    var attributes: DataAttributes,
    @SerializedName("relationships")
    var relationships: DataRelationship?,
)

data class DataAttributes(
    @SerializedName("title")
    var title: String,
)

data class DataRelationship(
    @SerializedName("items")
    var items: DataItems
)

data class DataItems(
    @SerializedName("data")
    var data: List<DatumData>,
)

data class DatumData(
    @SerializedName("type")
    var type: String,
    @SerializedName("attributes")
    var attributes: Attributes,
)

data class Attributes(
    @SerializedName("title")
    var title: String,
    @SerializedName("imageUrl")
    var imageUrl: String?,
    @SerializedName("images")
    var images: List<Images>
)

data class Images(
    @SerializedName("url")
    var url: String,
)
