package com.kelompok1.ebaak.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kelompok1.ebaak.R
import com.kelompok1.ebaak.databinding.ActivityDetailBinding
import com.kelompok1.ebaak.response.InformasiList
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_INFORMASI = "extra_informasi"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val recipes = intent.getParcelableExtra<InformasiList>(EXTRA_INFORMASI)

        recipes?.let {
            initView(it) }
    }

    private fun initView( informasi: InformasiList) {

        Glide.with(this)
            .load(informasi.link_gambar)
            .apply(
                RequestOptions().dontTransform().placeholder(R.drawable.ic_broken_image)
            )
            .into(div)

        dtv1.text = informasi.judul
        dtv2.text = informasi.isi

    }

}