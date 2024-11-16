package com.kelompok1.ebaak.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kelompok1.ebaak.R
import com.kelompok1.ebaak.response.InformasiList
import kotlinx.android.synthetic.main.list_data.view.*

class InformasiAdapter (private val listener: (InformasiList) -> Unit) :
    RecyclerView.Adapter <InformasiAdapter.ViewHolder> () {

    private var informasi: List<InformasiList> = listOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setInformasi(informasi : List<InformasiList>) {
        this.informasi = informasi
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent : ViewGroup, viewType: Int) : ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_data, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder : ViewHolder, position: Int) {
        holder.bind(informasi[position])
    }

    override fun getItemCount(): Int {
        return informasi.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(informasi : InformasiList) {
            Glide.with(itemView.context)
                .load(informasi.link_gambar)
                .apply(RequestOptions().dontTransform().placeholder(R.drawable.ic_broken_image))
                .into(itemView.iv)

            itemView.tv1.text = informasi.judul
            itemView.tv2.text = informasi.isi

            itemView.setOnClickListener {
                listener(informasi)
            }
        }
    }

}

