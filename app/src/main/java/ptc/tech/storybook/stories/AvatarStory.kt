package ptc.tech.storybook.stories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import ptc.tech.jet_components.*

@Composable
fun AvatarStory() {
 val imageUrl =  "https://i.picsum.photos/id/1083/200/300.jpg?hmac=Cb2IPPC1QKcreSR4t7ILwR62HeAnBS5y7pK9zl3XwI4"
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(64.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        item {
            TinyAvatar(imageUrl)
        }

        item{
            SmallAvatar(imageUrl)
        }

        item {
            MediumAvatar(imageUrl)
        }

        item {
            LargeAvatar(imageUrl)
        }

        item {
            HugeAvatar(imageUrl)
        }
    }
}