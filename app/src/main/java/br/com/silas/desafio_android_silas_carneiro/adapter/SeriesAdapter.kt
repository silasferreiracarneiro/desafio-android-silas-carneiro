package br.com.silas.desafio_android_silas_carneiro.adapter

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.silas.desafio_android_silas_carneiro.R
import br.com.silas.desafio_android_silas_carneiro.model.HeroSeries
import br.com.silas.desafio_android_silas_carneiro.ui.characterList.SerieSelect
import com.bumptech.glide.Glide
import com.mikhaellopez.circularimageview.CircularImageView

class SeriesAdapter(
    val list: ArrayList<HeroSeries>,
    val callback: SerieSelect
): RecyclerView.Adapter<SeriesAdapter.SeriesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.serie_item, parent, false)
        return SeriesHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: SeriesHolder, position: Int) {
        if(itemCount > 0) {
            val item = list[position]
            loadPhoto(item.thumbnail.path, item.thumbnail.extension, holder)
            holder.photo.setOnClickListener { callback.itemSelect(item) }
        }
    }

    private fun loadPhoto(
        posterPath: String,
        extension: String,
        holder: SeriesHolder
    ) {
        if(posterPath.isNotBlank() && posterPath.isNotEmpty()){
            Glide.with(holder.itemView.context)
                .load("${posterPath}.${extension}")
                .error(ColorDrawable(Color.RED))
                .into(holder.photo)
        }
    }

    class SeriesHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val photo: CircularImageView = itemView.findViewById(R.id.img_hero)
    }
}