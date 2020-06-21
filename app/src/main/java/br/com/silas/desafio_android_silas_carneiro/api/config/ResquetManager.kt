package br.com.silas.desafio_android_silas_carneiro.api.config

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Synchronized
suspend fun <T> doResquest(requestFunction: () -> T): ResultApi<T> {
    return withContext(Dispatchers.IO) {
        try {
            ResultApi.createSucess(
                requestFunction()
            )
        } catch (exception: Throwable) {
            ResultApi.createError<T>(exception)
        }
    }
}