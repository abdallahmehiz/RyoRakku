package xyz.mehiz.ryorakku.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import xyz.mehiz.ryorakku.data.DataStoreRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreDIM {
  @Provides
  @Singleton
  fun provideDataStoreRepository(@ApplicationContext context: Context) =
    DataStoreRepository(context)
}
