package xyz.mehiz.ryorakku.ui.onboarding

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes

sealed class OnBoardingPages(
  val title: String,
  val description: String,
) {
  object First : OnBoardingPages(
    title = "Welcome",
    description = "Welcome to Ryorakku, the app that helps you track, manage and discover new Anime and Manga."
  )

  object Second : OnBoardingPages(
    title = "Community",
    description = "Join the community and share your thoughts on Old, new and upcoming Anime and Manga."
  )

  object Third : OnBoardingPages(
    title = "Library",
    description = "This app is powered by AniList to Help you Manage and track your favorite anime" +
        " and manga, to use the full power of the app, i'd recommend logging in to your Anilist account."
  )
}
