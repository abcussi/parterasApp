package com.igorwojda.showcase.feature.album.data.model

import com.igorwojda.showcase.feature.album.data.enum.AlbumDataImageSize
import com.igorwojda.showcase.feature.album.domain.model.AlbumDomainModel
import com.squareup.moshi.Json

internal data class AlbumDataModel(
    @field:Json(name = "mbid") val mbId: String?,
    val name: String,
    val artist: String,
    val wiki: AlbumWikiDataModel?,
    @field:Json(name = "image") val images: List<AlbumImageDataModel>?
)

internal fun AlbumDataModel.toDomainModel(): AlbumDomainModel {
    val images = this.images
        ?.filterNot { it.size == AlbumDataImageSize.UNKNOWN || it.url.isBlank() }
        ?.map { it.toDomainModel() }

    return AlbumDomainModel(
        mbId = this.mbId,
        name = "LA EMERGENCIA DEL COVID 19 Y SUS EFECTOS EN LA SALUD BOLIVIANA",
        artist = "Qué es el COVID 19?\n" +
                "Es una enfermedad infecciosa causada por el coronavirus. El contagio se produce cuando una persona enferma tose o estornuda y expulsa partículas del virus que entran en contacto con otras personas.",
        images = images ?: listOf()
    )
}
