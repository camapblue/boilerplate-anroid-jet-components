package ptc.tech.jet_components

import androidx.compose.foundation.background
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.material.composethemeadapter.MdcTheme
import ptc.tech.jet_components.theme.Colors

@Composable
fun Button(
    title: String,
    backgroundColor: Color,
    highlightColor: Color
) {
    Surface(Modifier.background(color = Color.Transparent)) {

    }
}

@Preview()
@Composable
fun DefaultPreview() {
    MdcTheme {
        Button("Primary Button", backgroundColor = Colors.PrimaryColor, highlightColor = Colors.SecondaryColor)
    }
}