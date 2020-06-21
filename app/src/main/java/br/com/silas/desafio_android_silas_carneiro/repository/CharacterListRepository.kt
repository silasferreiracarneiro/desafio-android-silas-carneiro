package br.com.silas.desafio_android_silas_carneiro.repository

import br.com.silas.desafio_android_silas_carneiro.api.Api
import br.com.silas.desafio_android_silas_carneiro.api.config.DataResponse
import br.com.silas.desafio_android_silas_carneiro.api.config.ResultApi
import br.com.silas.desafio_android_silas_carneiro.api.config.doResquest
import br.com.silas.desafio_android_silas_carneiro.model.CharacterPerson
import br.com.silas.desafio_android_silas_carneiro.utils.Contants
import br.com.silas.desafio_android_silas_carneiro.utils.md5

class CharacterListRepository(private val api: Api) {

    suspend fun getListCharacter(): ResultApi<DataResponse<ArrayList<CharacterPerson>>> {
        val ts = (System.currentTimeMillis() / 1000).toString()
        return doResquest {
            api.getListCharacter(
                ts = (System.currentTimeMillis() / 1000).toString(),
                hash = md5(ts + Contants.KEY_PRIVATE + Contants.KEY_PUBLIC)
            ).await()
        }
    }
}