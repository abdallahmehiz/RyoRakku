package xyz.mehiz.ryorakku.ui.home.discover

import android.annotation.SuppressLint
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import coil.compose.AsyncImage
import com.apollographql.apollo3.ApolloClient
import xyz.mehiz.ryorakku.HomeMediaQuery
import xyz.mehiz.ryorakku.R
import xyz.mehiz.ryorakku.ui.theme.RyoRakkuTheme
import xyz.mehiz.ryorakku.utils.Constants

val apolloClient = ApolloClient.Builder().serverUrl(Constants.ANILIST_API_URL).build()

object DiscoverTab : Tab {
  @OptIn(ExperimentalAnimationGraphicsApi::class)
  override val options: TabOptions
    @SuppressLint("ResourceType") @Composable
    get() {
      val isSelected = LocalTabNavigator.current.current.key == key
      val title = "Discover"
      val image = AnimatedImageVector.animatedVectorResource(R.drawable.anim_browse)
      return TabOptions(
        index = 2u,
        title = title,
        icon = rememberAnimatedVectorPainter(image, isSelected)
      )
    }

  @OptIn(ExperimentalMaterial3Api::class)
  @Composable
  override fun Content() {
    RyoRakkuTheme {
      TopAppBar(title = {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
          Text(text = "Welcome, Abdallah")
          Spacer(modifier = Modifier.weight(1f))
          IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Outlined.Search, contentDescription = "Search")
          }
        }
      })
      var data by remember { mutableStateOf<HomeMediaQuery.Data?>(null) }
      LaunchedEffect(key1 = 1) { data = apolloClient.query(HomeMediaQuery()).execute().data }
      Column {
        data?.trendingManga?.let { CatalogCard("Trending Manga", it) }
      }
    }
  }
}

@Composable
fun VerticalMediaCard(
  title: String,
  image: String
) {
  Box(
    modifier = Modifier
      .width(100.dp)
      .clip(RoundedCornerShape(5))
  ) {
    Column {
      AsyncImage(
        modifier = Modifier
          .height((100 * 3 / 2).dp)
          .width(100.dp)
          .clip(RoundedCornerShape(5)),
        model = image,
        contentDescription = title,
        contentScale = ContentScale.FillBounds
      )
      Text(
        modifier = Modifier
          .width(100.dp),
        text = title,
        fontSize = 10.sp,
        lineHeight = 12.sp,
        fontWeight = FontWeight.Bold,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
      )
    }
  }
}

@Composable
fun CatalogCard(
  type: String,
  data: HomeMediaQuery.TrendingManga
) {
  Box(
    modifier = Modifier
      .clip(shape = RoundedCornerShape(10))
      .padding(vertical = 16.dp)
  ) {
    Column {
      Text(
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
        fontSize = 16.sp,
        style = MaterialTheme.typography.titleMedium,
        text = type
      )
      LazyRow {
        items(data.media?.size ?: 0) { index ->
          data.media?.get(index)?.mediaFields?.let {
            if (index == 0) Spacer(modifier = Modifier.width(16.dp))
            VerticalMediaCard(
              title = "${it.title?.userPreferred}",
              image = "${it.coverImage?.large}"
            )
            Spacer(modifier = Modifier.width(8.dp))
          }
        }
      }
    }
  }
}
