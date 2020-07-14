package br.com.silas.desafio_android_silas_carneiro.model

import com.google.gson.annotations.SerializedName

data class HqValue (

	@SerializedName("id") val id : Int,
	@SerializedName("digitalId") val digitalId : Int,
	@SerializedName("title") val title : String,
	@SerializedName("issueNumber") val issueNumber : Int,
	@SerializedName("variantDescription") val variantDescription : String,
	@SerializedName("description") val description : String,
	@SerializedName("modified") val modified : String,
	@SerializedName("isbn") val isbn : String,
	@SerializedName("upc") val upc : String,
	@SerializedName("diamondCode") val diamondCode : String,
	@SerializedName("ean") val ean : String,
	@SerializedName("issn") val issn : String,
	@SerializedName("format") val format : String,
	@SerializedName("pageCount") val pageCount : Int,
	@SerializedName("textObjects") val textObjects : List<TextObjects>,
	@SerializedName("resourceURI") val resourceURI : String,
	@SerializedName("urls") val urls : List<Urls>,
	@SerializedName("series") val series : SeriesHq,
	@SerializedName("prices") val prices : List<Prices>,
	@SerializedName("thumbnail") val thumbnail : Thumbnail,
	@SerializedName("images") val images : List<Images>,
	@SerializedName("events") val events : Events
)