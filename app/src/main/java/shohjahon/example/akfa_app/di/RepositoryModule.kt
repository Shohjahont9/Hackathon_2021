package com.example.note.ui.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import shohjahon.example.akfa_app.ui.home.deadline.DeadlineRepository
import shohjahon.example.akfa_app.ui.login.LoginRepository
import shohjahon.example.akfa_app.ui.stanok.StanokRepository
import uz.fizmasoft.xatlov.network.ApiService

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideLoginRepository(
        api:ApiService
    ): LoginRepository = LoginRepository(api)

    @Provides
    @ViewModelScoped
    fun provideDeadlineRepository(
        api:ApiService
    ): DeadlineRepository = DeadlineRepository(api)

    @Provides
    @ViewModelScoped
    fun provideStanokRepository(
        api:ApiService
    ): StanokRepository = StanokRepository(api)


}

