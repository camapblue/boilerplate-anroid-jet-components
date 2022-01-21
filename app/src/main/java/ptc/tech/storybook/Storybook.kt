package ptc.tech.storybook

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import ptc.tech.storybook.ui.theme.StorybookTheme

class CurrentStory(
    var story: Story? = null
) {
    companion object {
        val instance = CurrentStory()
    }
}

class Story(
    val title: String,
    val builder: @Composable () -> Unit
)

class StoryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CurrentStory.instance.story?.let {
            val story = it
            setContent {
                val activity = (LocalContext.current as? Activity)

                StorybookTheme {
                    Scaffold(topBar = {
                        TopAppBar(
                            title = { Text(story.title) },
                            navigationIcon = {
                                IconButton(onClick = {
                                    activity?.finish()
                                }) {
                                    Icon(
                                        imageVector = Icons.Filled.ArrowBack,
                                        contentDescription = "Back",
                                    )
                                }
                            }
                        )
                    }) {
                        story.builder()
                    }
                }
            }
        }
    }
}

@Composable
fun StoryRowItem(
    story: Story
) {
    val context = LocalContext.current

    Surface(Modifier.background(color = Color.White)) {
        Column {
            Row(modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .clickable {
                    CurrentStory.instance.story = story
                    val intent = Intent(context, StoryActivity::class.java)
                    context.startActivity(intent)
                }, horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(story.title)
                Icon(Icons.Filled.ArrowForward, "", tint = Color.DarkGray)
            }
            Divider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}