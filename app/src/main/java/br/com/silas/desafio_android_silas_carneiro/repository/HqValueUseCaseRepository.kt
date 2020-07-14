package br.com.silas.desafio_android_silas_carneiro.repository

import br.com.silas.desafio_android_silas_carneiro.api.Api
import br.com.silas.desafio_android_silas_carneiro.api.config.DataResponse
import br.com.silas.desafio_android_silas_carneiro.api.config.ResultApi
import br.com.silas.desafio_android_silas_carneiro.api.config.doResquest
import br.com.silas.desafio_android_silas_carneiro.model.HqValue
import br.com.silas.desafio_android_silas_carneiro.utils.Contants
import br.com.silas.desafio_android_silas_carneiro.utils.md5

class HqValueUseCaseRepository(private val api: Api) {

    suspend fun getListHq(idHero: Int): ResultApi<DataResponse<ArrayList<HqValue>>> {
        return doResquest {
            val ts = (System.currentTimeMillis() / 1000).toString()
            api.getListHq(idHero,
                        ts = ts,
                        hash = md5(ts + Contants.KEY_PRIVATE + Contants.KEY_PUBLIC)
            ).await()
        }
    }
}