package ptc.tech.storybook.stories

import androidx.compose.runtime.Composable
import ptc.tech.jet_components.Avatar

@Composable
fun AvatarStory() {
    Avatar(
        imageUrl = "https://i.picsum.photos/id/1083/200/300.jpg?hmac=Cb2IPPC1QKcreSR4t7ILwR62HeAnBS5y7pK9zl3XwI4",
        sizeInDp = 64f
    )
}