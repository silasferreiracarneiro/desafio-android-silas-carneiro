package br.com.silas.desafio_android_silas_carneiro.provider

import br.com.silas.desafio_android_silas_carneiro.repository.HqValueUseCaseRepository
import br.com.silas.desafio_android_silas_carneiro.usecase.HqValueUseCase

fun providerHqValueUseCaseRepository(): HqValueUseCaseRepository {
    return HqValueUseCaseRepository(providerApi())
}

@JvmOverloads
fun providerHqValueUseCase(): HqValueUseCase {
    return HqValueUseCase(providerHqValueUseCaseRepository())
}