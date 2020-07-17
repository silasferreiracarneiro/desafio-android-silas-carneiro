package br.com.silas.desafio_android_silas_carneiro.model

import com.google.gson.annotations.SerializedName

data class HeroSeries (

	@SerializedName("id") val id : Int,
	@SerializedName("title") val title : String,
	@SerializedName("description") val description : String,
	@SerializedName("thumbnail") val thumbnail : Thumbnail
)