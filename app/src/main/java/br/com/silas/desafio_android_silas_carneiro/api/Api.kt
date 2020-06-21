package br.com.silas.desafio_android_silas_carneiro.api

import br.com.silas.desafio_android_silas_carneiro.api.config.DataResponse
import br.com.silas.desafio_android_silas_carneiro.model.CharacterPerson
import br.com.silas.desafio_android_silas_carneiro.utils.Contants.KEY_PUBLIC
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface Api {

    @GET("/v1/public/characters")
    fun getListCharacter(@Query("ts") ts: String,
                         @Query("orderBy") orderBy: String = "name",
                         @Query("apikey") apikey: String = KEY_PUBLIC,
                         @Query("hash") hash: String): Deferred<DataResponse<ArrayList<CharacterPerson>>>
}