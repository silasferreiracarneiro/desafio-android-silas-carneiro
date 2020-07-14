package br.com.silas.desafio_android_silas_carneiro.model

import com.google.gson.annotations.SerializedName

data class Images (

	@SerializedName("path") val path : String,
	@SerializedName("extension") val extension : String
)