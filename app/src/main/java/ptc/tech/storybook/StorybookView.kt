package ptc.tech.storybook

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun StorybookView(
    stories: List<Story>,
    navController: NavHostController
) {
    Surface(Modifier.background(color = Color.White)) {
        LazyColumn {
            items(stories) { story ->
                StoryRowItem(story = story, navController = navController)
            }
        }
    }
}