package com.hani.mediaplayer.mediacontrol

import androidx.annotation.IntDef


data class AudioDataItem(
    var mediaID: Int, @MediaType var mediaSourceType: Int, var path: String
)


@Retention(AnnotationRetention.SOURCE)
@IntDef(MEDIA_SOURCE_URL, MEDIA_SOURCE_STORAGE)
annotation class MediaType

const val MEDIA_SOURCE_URL = 0
const val MEDIA_SOURCE_STORAGE = 1
