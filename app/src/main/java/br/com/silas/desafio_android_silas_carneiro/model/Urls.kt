package br.com.silas.desafio_android_silas_carneiro.model

import com.google.gson.annotations.SerializedName

data class Urls (

	@SerializedName("type") val type : String,
	@SerializedName("url") val url : String
)