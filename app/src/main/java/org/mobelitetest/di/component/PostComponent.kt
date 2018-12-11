package org.mobelitetest.di.component

import dagger.Component
import org.mobelitetest.di.module.PostModule
import org.mobelitetest.di.scope.PostScope
import org.mobelitetest.ui.post.PostsFragment


/**
 * Created by Ali DOUIRI on 09/12/2018.
 * my.alidouiri@gmail.com
 */
@PostScope
@Component(modules = arrayOf(PostModule::class), dependencies = arrayOf(RemoteComponent::class))
interface PostComponent {

    fun inject(view: PostsFragment)
}