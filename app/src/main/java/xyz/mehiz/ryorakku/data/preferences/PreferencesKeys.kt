package xyz.mehiz.ryorakku.data.preferences

import androidx.datastore.preferences.core.booleanPreferencesKey

object PreferencesKeys {
  val onBoardingComplete = booleanPreferencesKey(name = "on_boarding_complete")
}
