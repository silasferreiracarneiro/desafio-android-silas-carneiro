package br.com.silas.desafio_android_silas_carneiro.model

import com.google.gson.annotations.SerializedName

data class Stories (

	@SerializedName("available") val available : Int,
	@SerializedName("collectionURI") val collectionURI : String,
	@SerializedName("items") val items : List<Items>,
	@SerializedName("returned") val returned : Int
)