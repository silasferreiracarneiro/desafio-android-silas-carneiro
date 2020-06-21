package br.com.silas.desafio_android_silas_carneiro.provider

import br.com.silas.desafio_android_silas_carneiro.api.Api
import br.com.silas.desafio_android_silas_carneiro.api.config.RetrofitConfig

fun providerApi(): Api = RetrofitConfig().api