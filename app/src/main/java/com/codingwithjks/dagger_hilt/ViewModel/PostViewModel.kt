package com.codingwithjks.dagger_hilt.ViewModel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithjks.dagger_hilt.Model.Post
import com.codingwithjks.dagger_hilt.Repository.PostRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class PostViewModel @ViewModelInject constructor(private val postRepository: PostRepository)  : ViewModel(){
    val postLiveData : MutableLiveData<List<Post>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            postRepository.getPost()
                .catch {e->
                    Log.d("main", "getPost: ${e.message}")
                }.collect {response->
                    postLiveData.value=response
                }

        }
    }
}