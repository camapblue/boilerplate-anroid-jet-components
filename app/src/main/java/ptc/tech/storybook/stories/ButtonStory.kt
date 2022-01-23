package ptc.tech.storybook.stories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ptc.tech.jet_components.Button

@Composable
fun ButtonStory() {
    Button(
        "Button",
        backgroundColor = Color.Cyan,
        highlightColor = Color.Red,
        textColor = Color.Black
    )
    /*Surface(Modifier.background(color = Color.White)) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text("Here is Button Story", color = Color.Black, fontSize = 15.sp)
        }
    }*/
}