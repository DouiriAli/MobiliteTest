package org.mobelitetest.di.module

import dagger.Module
import dagger.Provides
import org.mobelitetest.data.remote.RemoteService
import org.mobelitetest.di.scope.PostScope
import org.mobelitetest.ui.post.PostPresenter


/**
 * Created by Ali DOUIRI on 09/12/2018.
 * my.alidouiri@gmail.com
 */
@Module
class PostModule {

    @Provides
    @PostScope
    fun providesPostPresenter(remoteService : RemoteService): PostPresenter = PostPresenter(remoteService)
}
