package xyz.mehiz.ryorakku.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "preferences")

class DataStoreRepository(context: Context) {
  private val dataStore = context.dataStore

  suspend fun saveBoolean(key: Preferences.Key<Boolean>, value: Boolean) {
    dataStore.edit { preferences ->
      preferences[key] = value
    }
  }

  fun readBoolean(key: Preferences.Key<Boolean>): Flow<Boolean> {
    return dataStore.data.map { preferences ->
      preferences[key] ?: false
    }
  }
}
