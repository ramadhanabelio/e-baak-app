package com.kelompok1.ebaak.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InformasiResponse(

    @SerializedName("method")
    val method : String?,

    @SerializedName("status")
    val status : String?,

    @SerializedName("results")
    val results : List<InformasiList?>? = null,

) : Parcelable

@Parcelize
data class InformasiList(

    @SerializedName("link_gambar")
    val link_gambar: String?,

    @SerializedName("judul")
    val judul: String?,

    @SerializedName("isi")
    val isi: String?,

) : Parcelable