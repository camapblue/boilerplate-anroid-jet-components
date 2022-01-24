package ptc.tech.storybook.stories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ptc.tech.jet_components.*
import ptc.tech.jet_components.theme.Colors

@Composable
fun ButtonStory() {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(64.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        item{
            PrimaryButton()
        }
        item {
            SecondaryButton()
        }
        item {
            PaddingButton()
        }
        item {
            SecondaryPaddingButton()
        }
    }
}