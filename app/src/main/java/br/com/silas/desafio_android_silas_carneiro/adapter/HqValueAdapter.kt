package br.com.silas.desafio_android_silas_carneiro.adapter

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.silas.desafio_android_silas_carneiro.R
import br.com.silas.desafio_android_silas_carneiro.model.HqValue
import com.bumptech.glide.Glide

class HqValueAdapter(var hqs: ArrayList<HqValue>): RecyclerView.Adapter<HqValueAdapter.HqValueHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HqValueHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_list_hq, parent, false)
        return HqValueHolder(view)
    }

    override fun getItemCount(): Int = hqs.size

    override fun onBindViewHolder(holder: HqValueHolder, position: Int) {
        if(itemCount > 0) {
            val item = hqs[position]
            holder.title.text = item.title
            holder.price.text = item.prices.maxBy { it.price }?.price.toString()
            loadPhoto(item.thumbnail.path, item.thumbnail.extension, holder)
        }
    }

    private fun loadPhoto(
        posterPath: String,
        extension: String,
        holder: HqValueHolder
    ) {
        if(posterPath.isNotBlank() && posterPath.isNotEmpty()){
            Glide.with(holder.itemView.context)
                .load("${posterPath}.${extension}")
                .error(ColorDrawable(Color.RED))
                .into(holder.photo)
        }
    }

    class HqValueHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val photo: ImageView = itemView.findViewById(R.id.img_hero)
        val title: TextView = itemView.findViewById(R.id.txt_title)
        val price: TextView = itemView.findViewById(R.id.txt_price)
    }
}