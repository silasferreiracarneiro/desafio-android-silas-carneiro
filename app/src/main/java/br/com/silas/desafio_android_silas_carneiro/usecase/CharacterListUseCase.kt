package br.com.silas.desafio_android_silas_carneiro.usecase

import br.com.silas.desafio_android_silas_carneiro.repository.CharacterListRepository

class CharacterListUseCase(private val repository: CharacterListRepository) {
    suspend fun getListCharacter() = repository.getListCharacter()

    suspend fun getSeries(id: Int) = repository.getSeries(id)
}