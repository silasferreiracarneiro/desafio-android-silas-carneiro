package br.com.silas.desafio_android_silas_carneiro.model

import com.google.gson.annotations.SerializedName

data class SeriesHq (

	@SerializedName("resourceURI") val resourceURI : String,
	@SerializedName("name") val name : String
)