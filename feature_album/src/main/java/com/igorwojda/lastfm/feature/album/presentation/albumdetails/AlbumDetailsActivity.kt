package com.igorwojda.lastfm.feature.album.presentation.albumdetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.igorwojda.lastfm.feature.album.R
import com.igorwojda.lastfm.feature.base.presentation.BaseActivity
import com.igorwojda.lastfm.feature.base.presentation.extension.extra

internal class AlbumDetailsActivity : BaseActivity() {

    companion object {
        private const val EXTRA_ALBUM_NAME = "EXTRA_ALBUM_NAME"
        private const val EXTRA_ARTIST_NAME = "EXTRA_ARTIST_NAME"
        private const val EXTRA_MB_ID = "EXTRA_MB_ID"

        fun getStartIntent(
            context: Context,
            artistName: String,
            albumName: String,
            mbId: String?
        ) =
            Intent(context, AlbumDetailsActivity::class.java).apply {
                putExtra(EXTRA_ARTIST_NAME, artistName)
                putExtra(EXTRA_ALBUM_NAME, albumName)
                putExtra(EXTRA_MB_ID, mbId)
            }
    }

    override val layoutResourceId = R.layout.activity_album_details

    private val albumName by extra<String>(EXTRA_ALBUM_NAME)
    private val artistName by extra<String>(EXTRA_ARTIST_NAME)
    private val mbId by extra<String>(EXTRA_MB_ID)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        displayFragment { AlbumDetailFragment(albumName, artistName, mbId) }
    }
}