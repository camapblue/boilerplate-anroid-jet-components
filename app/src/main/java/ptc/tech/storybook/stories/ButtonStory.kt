package ptc.tech.storybook.stories

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ptc.tech.jet_components.Button

@Composable
fun ButtonStory() {
    Button(
        title = "Button",
        backgroundColor = Color.Cyan,
        highlightColor = Color.Red,
        textColor = Color.Black
    )
}