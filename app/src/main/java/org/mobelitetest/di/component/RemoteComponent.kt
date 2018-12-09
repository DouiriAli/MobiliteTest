package org.mobelitetest.di.component

import dagger.Component
import org.mobelitetest.data.remote.RemoteService
import org.mobelitetest.di.module.RemoteModule
import javax.inject.Singleton


/**
 * Created by Ali DOUIRI on 09/12/2018.
 * my.alidouiri@gmail.com
 */
@Singleton
@Component(modules = arrayOf(RemoteModule::class))
interface RemoteComponent {

    fun remoteService(): RemoteService

}