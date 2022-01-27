package ptc.tech.storybook.stories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import ptc.tech.jet_components.*

@Composable
fun TextFieldStory() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(64.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        item {
            NormalText(
                label = "Label"
            )
        }
        item {
            NormalText(
                label = "Label",
                hint = "Prompt"
            )
        }
        item {
            NormalText(
                label = "Label",
                text = "Entry",
                hint = "Prompt"
            )
        }
        item {
            NormalText(
                label = "Label",
                text = "Entry",
                isError = true,
                errorMessage = "Error message"
            )
        }
        item {
            NormalText(
                label = "Label",
                isEnable = false
            )
        }
        item {
            NormalText(
                label = "Label",
                text = "Entry",
                isEnable = false
            )
        }
        item {
            CameraText(
                label = "Label"
            )
        }
        item {
            CameraText(
                label = "Label",
                hint = "Prompt"
            )
        }
        item {
            CameraText(
                label = "Label",
                text = "Entry",
                hint = "Prompt"
            )
        }
        item {
            CameraText(
                label = "Label",
                text = "Entry",
                isError = true,
                errorMessage = "Error message"
            )
        }
        item {
            CameraText(
                label = "Label",
                isEnable = false
            )
        }
        item {
            CameraText(
                label = "Label",
                text = "Entry",
                isEnable = false
            )
        }
    }
}