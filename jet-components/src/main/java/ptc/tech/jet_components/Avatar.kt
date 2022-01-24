package ptc.tech.jet_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation

@Composable
fun Avatar(
    imageUrl: String,
    sizeInDp: Float
) {
    Image(
        painter = rememberImagePainter(
            data = imageUrl,
            builder = {
                transformations(CircleCropTransformation())
            }
        ),
        contentDescription = null,
        modifier = Modifier.size(sizeInDp.dp)
    )
}

@Composable
fun TinyAvatar(
    imageUrl: String
) {
    Avatar(imageUrl, 32f)
}

@Composable
fun SmallAvatar(
    imageUrl: String
) {
    Avatar(imageUrl, 64f)
}

@Composable
fun MediumAvatar(
    imageUrl: String
) {
    Avatar(imageUrl, 128f)
}

@Composable
fun LargeAvatar(
    imageUrl: String
) {
    Avatar(imageUrl, 256f)
}

@Composable
fun HugeAvatar(
    imageUrl: String
) {
    Avatar(imageUrl, 512f)
}