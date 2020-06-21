package br.com.silas.desafio_android_silas_carneiro.api.config

import com.google.gson.annotations.SerializedName

class DataResponse<T> {
    @SerializedName("code")
    var statusCode: Int? = null
    @SerializedName("status")
    var status: String? = null
    @SerializedName("copyright")
    var copyright: String? = null
    @SerializedName("attributionText")
    var attributionText: String? = null
    @SerializedName("data")
    var data: ResultResponse<T>? = null
}