package org.mobelitetest.data.remote

import io.reactivex.Observable
import org.mobelitetest.data.model.Post
import retrofit2.Response
import retrofit2.http.GET


/**
 * Created by Ali DOUIRI on 09/12/2018.
 * my.alidouiri@gmail.com
 */
interface RemoteService {

    @GET("posts")
    fun getPosts() : Observable<Response<List<Post>>>
}