package com.example.note.ui.di

import com.example.note.ui.db.DAO
import com.example.note.ui.ui.activityPage.ActivityPageRepository
import com.example.note.ui.ui.home.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideHomeRepository(
        db: DAO
    ): HomeRepository = HomeRepository(db)

    @Provides
    @ViewModelScoped
    fun provideActivityPageRepository(
        db: DAO
    ): ActivityPageRepository = ActivityPageRepository(db)


}

