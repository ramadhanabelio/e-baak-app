package com.kelompok1.ebaak.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kelompok1.ebaak.activity.DetailActivity.Companion.EXTRA_INFORMASI
import com.kelompok1.ebaak.adapter.InformasiAdapter
import com.kelompok1.ebaak.databinding.ActivityMainBinding
import com.kelompok1.ebaak.response.InformasiList
import com.kelompok1.ebaak.response.InformasiResponse
import com.kelompok1.ebaak.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: InformasiAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getInformasi()
        initRV()
    }

    private fun getInformasi() {
        ApiClient.get().getInformasiList().enqueue(object : Callback<InformasiResponse> {
            override fun onResponse(
                call: Call<InformasiResponse>,
                response: Response<InformasiResponse>
            ) {
                if(response.isSuccessful){
                    val results : List<InformasiList> = response.body()?.results as List<InformasiList>
                    adapter.setInformasi(results)
                }
            }
            override fun onFailure(call: Call<InformasiResponse>, t: Throwable) {
            }

        })
    }

    private fun initRV() {
        adapter = InformasiAdapter {
            moveActivity(it)
        }
        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter       = adapter
    }

    private fun moveActivity(informasi: InformasiList) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(EXTRA_INFORMASI, informasi)
        startActivity(intent)
    }
}