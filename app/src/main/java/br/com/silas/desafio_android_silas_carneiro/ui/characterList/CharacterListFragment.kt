package br.com.silas.desafio_android_silas_carneiro.ui.characterList

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.silas.desafio_android_silas_carneiro.R
import br.com.silas.desafio_android_silas_carneiro.viewmodel.CharacterListViewModel

class CharacterListFragment : Fragment() {

    companion object {
        fun newInstance() =
            CharacterListFragment()
    }

    private lateinit var viewModel: CharacterListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.character_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(CharacterListViewModel::class.java)
        // TODO: Use the ViewModel
    }
}