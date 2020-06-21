package br.com.silas.desafio_android_silas_carneiro.ui.characterList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.silas.desafio_android_silas_carneiro.R
import br.com.silas.desafio_android_silas_carneiro.model.CharacterPerson
import br.com.silas.desafio_android_silas_carneiro.ui.base.BaseFragment
import br.com.silas.desafio_android_silas_carneiro.viewmodel.CharacterListViewModel
import br.com.silas.desafio_android_silas_carneiro.viewmodel.states.characterList.CharacterListState

class CharacterListFragment : BaseFragment() {

    private lateinit var viewmodel: CharacterListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_character_list, container, false)

        bindViewModel()
        addObservable()
        getListCharacter()

        return view
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

    }

    private fun errorCallApi(message: String?) {

    }

    private fun bindViewModel() {
        viewmodel = ViewModelProviders.of(this).get(CharacterListViewModel::class.java)
    }

    private fun getListCharacter() {
        viewmodel.getListCharacter()
    }
}