package br.com.silas.desafio_android_silas_carneiro.viewmodel.states.characterList

import br.com.silas.desafio_android_silas_carneiro.model.CharacterPerson
import br.com.silas.desafio_android_silas_carneiro.model.HeroSeries

open class CharacterListState {
    data class SucessCallApi(val result: ArrayList<CharacterPerson>?) : CharacterListState()
    data class SucessCallApiSeries(val result: java.util.ArrayList<HeroSeries>?) : CharacterListState()
    data class ErrorCallApi(val message: String?) : CharacterListState()
}