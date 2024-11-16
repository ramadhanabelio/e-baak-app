package com.kelompok1.ebaak.service

import com.kelompok1.ebaak.response.InformasiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("informasi.php")
    fun getInformasiList() : Call<InformasiResponse>
}