package com.codingwithjks.dagger_hilt.Network

import com.codingwithjks.dagger_hilt.Model.Post
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
   suspend fun getPosts() : List<Post>
}