package br.com.silas.desafio_android_silas_carneiro.viewmodel.states.characterList

import br.com.silas.desafio_android_silas_carneiro.model.CharacterPerson

open class CharacterListState {
    data class SucessCallApi(val result: ArrayList<CharacterPerson>?) : CharacterListState()
    data class ErrorCallApi(val message: String?) : CharacterListState()
}