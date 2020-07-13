package br.com.silas.desafio_android_silas_carneiro.ui.characterList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.silas.desafio_android_silas_carneiro.R
import br.com.silas.desafio_android_silas_carneiro.adapter.CharacterListAdapter
import br.com.silas.desafio_android_silas_carneiro.model.CharacterPerson
import br.com.silas.desafio_android_silas_carneiro.ui.base.BaseFragment
import br.com.silas.desafio_android_silas_carneiro.utils.Contants.HERO
import br.com.silas.desafio_android_silas_carneiro.viewmodel.CharacterListViewModel
import br.com.silas.desafio_android_silas_carneiro.viewmodel.states.characterList.CharacterListState

class CharacterListFragment : BaseFragment(), CharacterSelect {

    //TODO: Adicionar
    //https://github.com/yarolegovich/DiscreteScrollView
    //https://github.com/skydoves/transformationlayout

    private lateinit var viewmodel: CharacterListViewModel

    private lateinit var recycler: RecyclerView

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
    }

    private fun addObservable() {
        viewmodel.viewState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is CharacterListState.SucessCallApi -> sucessCallApi(it.result)
                is CharacterListState.ErrorCallApi -> errorCallApi(it.message)
            }
        })
    }

    private fun sucessCallApi(result: ArrayList<CharacterPerson>?) {
        result?.let {
            configureAdapter(it)
        }
    }

    private fun errorCallApi(message: String?) {

    }

    private fun bindViewModel() {
        viewmodel = ViewModelProviders.of(this).get(CharacterListViewModel::class.java)
    }

    private fun getListCharacter() {
        viewmodel.getListCharacter()
    }

    private fun configureAdapter(it: ArrayList<CharacterPerson>) {
        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.isNestedScrollingEnabled = false
        recycler.adapter = CharacterListAdapter(it, this)
        ((recycler.adapter as CharacterListAdapter).notifyDataSetChanged())
    }

    override fun itemClicked(hero: CharacterPerson) {
        val bundle = bundleOf(Pair(HERO, hero))
        view?.findNavController()?.navigate(R.id.action_characterListFragment_to_detailCharacterFragment, bundle)
    }
}

interface CharacterSelect {
    fun itemClicked(hero: CharacterPerson)
}