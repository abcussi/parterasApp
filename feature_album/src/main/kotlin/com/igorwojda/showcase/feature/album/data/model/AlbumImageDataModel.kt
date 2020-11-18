package com.igorwojda.showcase.feature.album.data.model

import com.igorwojda.showcase.feature.album.data.enum.AlbumDataImageSize
import com.igorwojda.showcase.feature.album.data.enum.toDomainEnum
import com.igorwojda.showcase.feature.album.domain.model.AlbumImageDomainModel
import com.squareup.moshi.Json

internal data class AlbumImageDataModel(
    @field:Json(name = "#text") val url: String,
    val size: AlbumDataImageSize
)

internal fun AlbumImageDataModel.toDomainModel() = AlbumImageDomainModel(
    url = "https://www.vaticannews.va/content/dam/vaticannews/agenzie/images/reuters/2020/06/01/23/1591045951914.JPG/_jcr_content/renditions/cq5dam.thumbnail.cropped.1000.563.jpeg",
    size = this.size.toDomainEnum()
)
