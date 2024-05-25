package com.example.data.model

import android.os.Parcelable
import com.example.domain.model.Image
import kotlinx.parcelize.Parcelize

@Parcelize
data class BoardParcel(
    val title: String,
    val content: String,
    val images: List<Image>
) : Parcelable