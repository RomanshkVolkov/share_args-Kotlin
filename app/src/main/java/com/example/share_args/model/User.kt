package com.example.share_args.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class User (
    val name: String,
    val lastname: String,
    val age: Int
) : Parcelable