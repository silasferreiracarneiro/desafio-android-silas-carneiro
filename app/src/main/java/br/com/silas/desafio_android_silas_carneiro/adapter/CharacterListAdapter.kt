package br.com.silas.desafio_android_silas_carneiro.adapter

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.silas.desafio_android_silas_carneiro.R
import br.com.silas.desafio_android_silas_carneiro.model.CharacterPerson
import br.com.silas.desafio_android_silas_carneiro.ui.characterList.CharacterSelect
import com.bumptech.glide.Glide

class CharacterListAdapter (var heros: ArrayList<CharacterPerson>, val listener: CharacterSelect):
    RecyclerView.Adapter<CharacterListAdapter.CharacterListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        return CharacterListHolder(view)
    }

    override fun getItemCount(): Int {
        return heros.size
    }

    override fun onBindViewHolder(holder: CharacterListHolder, position: Int) {
        if(itemCount > 0) {
            val item = heros[position]
            loadPhoto(item.thumbnail.path, item.thumbnail.extension, holder)
            holder.characterListHolder = item
            holder.photo.setOnClickListener { listener.itemClicked(item) }
        }
    }

    private fun loadPhoto(
        posterPath: String,
        extension: String,
        holder: CharacterListHolder
    ) {
        if(posterPath.isNotBlank() && posterPath.isNotEmpty()){
            Glide.with(holder.itemView.context)
                .load("${posterPath}.${extension}")
                .error(ColorDrawable(Color.RED))
                .into(holder.photo)
        }
    }

    class CharacterListHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val photo: ImageView = itemView.findViewById(R.id.img_hero)
        var characterListHolder: CharacterPerson? = null
    }
}