package com.codingwithrufat.dihilt.models

import com.google.gson.annotations.SerializedName

data class Response(
	val page: Int,
	val totalPages: Int,
	val results: List<ResponseItem>,
	val totalResults: Int
)

data class ResponseItem(
	val overview: String,
	val originalLanguage: String,
	@SerializedName("original_title")
	val originalTitle: String,
	val video: Boolean,
	val title: String,
	val genreIds: List<Int>,
	val posterPath: String,
	@SerializedName("backdrop_path")
	val backdropPath: String,
	val releaseDate: String,
	val popularity: Double,
	val voteAverage: Double,
	val id: Int,
	val adult: Boolean,
	val voteCount: Int
)

