package ptc.tech.storybook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ptc.tech.storybook.stories.AvatarStory
import ptc.tech.storybook.stories.ButtonStory
import ptc.tech.storybook.ui.theme.StorybookTheme

class MainActivity : ComponentActivity() {
    private val stories = listOf(
        Story(title = "Button View") {
            ButtonStory()
        },
        Story(title = "Image View") {
            AvatarStory()
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StorybookTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Scaffold(topBar = { TopAppBar(title = { Text("Storybook") }) }) {
                    NavHost(navController, startDestination = "storybook") {
                        composable(route = "storybook") {
                            StorybookView(stories = stories)
                        }
                    }
                }
            }
        }
    }
}
