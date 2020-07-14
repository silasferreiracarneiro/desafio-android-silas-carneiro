package br.com.silas.desafio_android_silas_carneiro.usecase

import br.com.silas.desafio_android_silas_carneiro.repository.HqValueUseCaseRepository

class HqValueUseCase (private val repository: HqValueUseCaseRepository) {

    suspend fun getListHq(idHero: Int)= repository.getListHq(idHero)
}