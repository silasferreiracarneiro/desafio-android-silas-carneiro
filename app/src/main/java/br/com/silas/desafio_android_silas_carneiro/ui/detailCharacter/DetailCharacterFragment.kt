package br.com.silas.desafio_android_silas_carneiro.ui.detailCharacter

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import br.com.silas.desafio_android_silas_carneiro.R
import br.com.silas.desafio_android_silas_carneiro.model.CharacterPerson
import br.com.silas.desafio_android_silas_carneiro.ui.hqValue.HqValueFragment
import br.com.silas.desafio_android_silas_carneiro.utils.Contants.HERO
import com.bumptech.glide.Glide

class DetailCharacterFragment : Fragment() {

    private lateinit var logo: ImageView
    private lateinit var title: TextView
    private lateinit var description: TextView
    private lateinit var btnHq: LinearLayout

    private lateinit var hero: CharacterPerson

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail_character, container, false)

        bindProperties(view)
        setValueProperties()
        setEvent()

        return view
    }

    private fun bindProperties(view: View) {
        logo = view.findViewById(R.id.img_logo)
        title = view.findViewById(R.id.txt_title)
        description = view.findViewById(R.id.txt_description)
        btnHq = view.findViewById(R.id.btn_hq)
    }

    private fun setEvent() {
        btnHq.setOnClickListener {
            activity?.let {
                HqValueFragment.newInstance(hero.id).show(it.supportFragmentManager, this.tag)
            }
        }
    }

    private fun setValueProperties() {
        hero = arguments?.getSerializable(HERO) as CharacterPerson
        title.text = hero.name
        description.text = hero.description
        loadPhoto(hero)
    }

    private fun loadPhoto(hero: CharacterPerson) {
        Glide.with(this)
            .load("${hero.thumbnail.path}.${hero.thumbnail.extension}")
            .error(ColorDrawable(Color.RED))
            .into(logo)
    }
}