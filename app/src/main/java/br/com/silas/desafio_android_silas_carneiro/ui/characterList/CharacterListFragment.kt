package br.com.silas.desafio_android_silas_carneiro.ui.characterList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.silas.desafio_android_silas_carneiro.R
import br.com.silas.desafio_android_silas_carneiro.adapter.CharacterListAdapter
import br.com.silas.desafio_android_silas_carneiro.adapter.SeriesAdapter
import br.com.silas.desafio_android_silas_carneiro.model.CharacterPerson
import br.com.silas.desafio_android_silas_carneiro.model.HeroSeries
import br.com.silas.desafio_android_silas_carneiro.ui.base.BaseFragment
import br.com.silas.desafio_android_silas_carneiro.utils.Contants.HERO
import br.com.silas.desafio_android_silas_carneiro.viewmodel.CharacterListViewModel
import br.com.silas.desafio_android_silas_carneiro.viewmodel.states.characterList.CharacterListState
import com.yarolegovich.discretescrollview.DiscreteScrollView
import com.yarolegovich.discretescrollview.DiscreteScrollView.ScrollListener
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter
import com.yarolegovich.discretescrollview.transform.Pivot
import com.yarolegovich.discretescrollview.transform.ScaleTransformer

class CharacterListFragment : BaseFragment(), ScrollListener<CharacterListAdapter.CharacterListHolder> {

    private lateinit var viewmodel: CharacterListViewModel

    private lateinit var recycler: RecyclerView
    private lateinit var progress: ProgressBar
    private lateinit var caroussel: DiscreteScrollView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_character_list, container, false)

        bindProperties(view)
        bindViewModel()
        addObservable()
        getListCharacter()

        return view
    }

    private fun bindProperties(view: View) {
        this.recycler = view.findViewById(R.id.recycler_heros)
        this.progress = view.findViewById(R.id.load_heros)
        this.caroussel = view.findViewById(R.id.heroi_caroussel)
    }

    private fun addObservable() {
        viewmodel.viewState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is CharacterListState.SucessCallApi -> sucessCallApi(it.result)
                is CharacterListState.ErrorCallApi -> errorCallApi(it.message)
                is CharacterListState.SucessCallApiSeries -> sucessCallApiSeries(it.result)
            }
        })
    }

    private fun sucessCallApiSeries(result: ArrayList<HeroSeries>?) {
        result?.let {
            configureAdapter(it)
        }
    }

    private fun configureCaroussel(it: ArrayList<CharacterPerson>) {
        setFirstHero(it.first())

        caroussel.adapter = InfiniteScrollAdapter.wrap(CharacterListAdapter(it, object : CharacterSelect {
            override fun itemClicked(hero: CharacterPerson) {
                val bundle = bundleOf(Pair(HERO, hero))
                view?.findNavController()?.navigate(R.id.action_characterListFragment_to_detailCharacterFragment, bundle)
            }
        }))

        caroussel.setItemTransformer(
            ScaleTransformer.Builder()
                .setMaxScale(1.05f)
                .setMinScale(0.8f)
                .setPivotX(Pivot.X.CENTER)
                .setPivotY(Pivot.Y.BOTTOM)
                .build()
        )

        caroussel.addScrollListener(this)
    }

    private fun sucessCallApi(result: ArrayList<CharacterPerson>?) {
        result?.let {
            configureCaroussel(it)
            progress.visibility = View.GONE
            recycler.visibility = View.VISIBLE
        }
    }

    private fun setFirstHero(hero: CharacterPerson) {
        viewmodel.getSeries(hero.id)
    }

    private fun errorCallApi(message: String?) {
        progress.visibility = View.GONE
    }

    private fun bindViewModel() {
        viewmodel = ViewModelProviders.of(this).get(CharacterListViewModel::class.java)
    }

    private fun getListCharacter() {
        viewmodel.getListCharacter()
    }

    private fun configureAdapter(it: ArrayList<HeroSeries>) {

        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recycler.isNestedScrollingEnabled = false

        recycler.adapter = SeriesAdapter(it, object : SerieSelect {
            override fun itemSelect(serie: HeroSeries) {

            }
        })

        ((recycler.adapter as SeriesAdapter).notifyDataSetChanged())
    }

    override fun onScroll(
        p0: Float,
        p1: Int,
        p2: Int,
        p3: CharacterListAdapter.CharacterListHolder?,
        p4: CharacterListAdapter.CharacterListHolder?
    ) {
        p4?.characterListHolder?.let {
            viewmodel.getSeries(it.id)
        }
    }
}

interface CharacterSelect {
    fun itemClicked(hero: CharacterPerson)
}

interface SerieSelect {
    fun itemSelect(serie: HeroSeries)
}