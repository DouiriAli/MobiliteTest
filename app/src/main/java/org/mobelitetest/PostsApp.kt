package org.mobelitetest

import android.app.Application
import org.mobelitetest.di.component.DaggerPostComponent
import org.mobelitetest.di.component.DaggerRemoteComponent
import org.mobelitetest.di.module.PostModule
import org.mobelitetest.di.module.RemoteModule


/**
 * Created by Ali DOUIRI on 09/12/2018.
 * my.alidouiri@gmail.com
 */
class PostsApp : Application() {

    companion object {

        fun getPostComponent()  = DaggerPostComponent.builder().remoteComponent(DaggerRemoteComponent.builder()
                .remoteModule(RemoteModule())
                .build()).postModule(PostModule()).build()
    }

}