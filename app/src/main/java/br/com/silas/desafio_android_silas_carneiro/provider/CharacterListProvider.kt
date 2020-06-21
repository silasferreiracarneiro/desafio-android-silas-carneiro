package br.com.silas.desafio_android_silas_carneiro.provider

import br.com.silas.desafio_android_silas_carneiro.repository.CharacterListRepository
import br.com.silas.desafio_android_silas_carneiro.usecase.CharacterListUseCase

fun providerCharacterListReposity(): CharacterListRepository {
    return CharacterListRepository(providerApi())
}

@JvmOverloads
fun providerCharacterListUseCase(): CharacterListUseCase {
    return CharacterListUseCase(providerCharacterListReposity())
}