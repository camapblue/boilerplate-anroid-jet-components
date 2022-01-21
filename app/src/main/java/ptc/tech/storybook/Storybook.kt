package ptc.tech.storybook

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

class Story(
    val title: String,
    val route: String
)

@Composable
fun StoryRowItem(
    story: Story,
    navController: NavHostController,
) {
    Surface(Modifier.background(color = Color.White)) {
        Row(modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .clickable {
                navController.navigate(story.route)
            }) {
            Text(story.title)
            Spacer(modifier = Modifier.height(20.dp))
            Icon(Icons.Filled.ArrowForward, "", tint = Color.DarkGray)
        }
    }
}