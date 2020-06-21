package br.com.silas.desafio_android_silas_carneiro.api.config

import com.google.gson.annotations.SerializedName

class ResultResponse<T> {
    @SerializedName("offset")
    var offset: Int? = null
    @SerializedName("limit")
    var limit: Int? = null
    @SerializedName("total")
    var total: Int? = null
    @SerializedName("count")
    var count: Int? = null
    @SerializedName("results")
    var result: T? = null
}