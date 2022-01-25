package ptc.tech.storybook.stories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import ptc.tech.jet_components.*

@Composable
fun ButtonStory() {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(64.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        item {
            PrimaryButton()
        }
        item {
            PrimaryDisableButton()
        }
        item {
            SecondaryButton()
        }
        item {
            PrimaryBorderButton()
        }
        item {
            DisablePrimaryBorderButton()
        }
        item {
            SecondaryBorderButton()
        }
        item {
            DisableSecondaryBorderButton()
        }
    }
}