package com.codingwithrufat.dihilt.repository

import com.codingwithrufat.dihilt.api.ApiService
import com.codingwithrufat.dihilt.helper.Constants.API_KEY
import javax.inject.Inject

class GetAllDataRepository
@Inject
constructor(private val apiService: ApiService){

    suspend fun getTVShows() = apiService.getAllTVShows(API_KEY)

}