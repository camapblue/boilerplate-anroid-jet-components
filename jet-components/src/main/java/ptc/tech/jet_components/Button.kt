package ptc.tech.jet_components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.material.composethemeadapter.MdcTheme
import ptc.tech.jet_components.theme.Colors

@Composable
fun Button(
    title: String,
    backgroundColor: Color,
    highlightColor: Color,
    disabledColor: Color = Color.Gray,
    textSizeInSp: Float = 16f,
    textColor: Color,
    disableTextColor: Color = textColor,
    cornerRadiusInDp: Float = 0f,
    borderColor: Color? = null,
    disableBorderColor: Color? = borderColor,
    widthInDp: Float? = null,
    heightInDp: Float? = null,
    paddingInDp: Float? = null,
    isEnable: Boolean = true,
    onClickListener: () -> Unit = {}
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val emptyFunc = {}

    val backgroundByState = if (!isEnable) {
        disabledColor
    } else if (isPressed) {
        highlightColor
    } else {
        backgroundColor
    }

    val textColorByState = if (isEnable) {
        textColor
    } else {
        disableTextColor
    }

    androidx.compose.material.Button(
        interactionSource = interactionSource,
        onClick = if (isEnable) onClickListener else emptyFunc,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundByState,
            contentColor = textColorByState
        ),
        shape = RoundedCornerShape(corner = CornerSize(cornerRadiusInDp.dp)),
        border = BorderStroke(
            width = if (borderColor != null) 2.dp else 0.dp,
            color = if (isEnable) {
                borderColor ?: Color.Transparent
            } else {
                disableBorderColor ?: Color.Transparent
            }
        ),
        contentPadding = if (paddingInDp != null) PaddingValues(paddingInDp.dp) else ButtonDefaults.ContentPadding,
        enabled = isEnable,
        modifier = getModifier(widthInDp, heightInDp),
        elevation = ButtonDefaults.elevation(0.dp, 0.dp)
    ) {
        Text(title, color = textColorByState, fontSize = textSizeInSp.sp, fontWeight = FontWeight.Bold)
    }
}

private fun getModifier(
    widthInDp: Float? = null,
    heightInDp: Float? = null
): Modifier {
    var modifier: Modifier = Modifier

    if (widthInDp != null) {
        modifier = if (widthInDp < 0) {
            modifier.fillMaxWidth()
        } else {
            Modifier.width(widthInDp.dp)
        }
    }

    if (heightInDp != null) {
        modifier = if (heightInDp < 0) {
            modifier.fillMaxHeight()
        } else {
            modifier.height(heightInDp.dp)
        }
    }

    return modifier
}

@Composable
fun PrimaryButton(
    title: String = "Primary Button",
    onClickListener: () -> Unit = {},
) {
    MdcTheme {
        Button(
            title = title,
            backgroundColor = Colors.Button.PrimaryBackgroundColor,
            highlightColor = Colors.Button.HighlightPrimaryBackgroundColor,
            disabledColor = Colors.Button.DisableBackgroundColor,
            textColor = Colors.Button.TextColorBlack,
            disableTextColor = Colors.Button.TextColorGray,
            cornerRadiusInDp = 4f,
            widthInDp = -1f,
            heightInDp = 44f,
            onClickListener = onClickListener
        )
    }
}

@Composable
fun PrimaryDisableButton(
    title: String = "Primary Disable Button",
    onClickListener: () -> Unit = {}
) {
    MdcTheme {
        Button(
            title = title,
            backgroundColor = Colors.Button.PrimaryBackgroundColor,
            highlightColor = Colors.Button.HighlightPrimaryBackgroundColor,
            disabledColor = Colors.Button.DisableBackgroundColor,
            textColor = Colors.Button.TextColorBlack,
            disableTextColor = Colors.Button.TextColorGray,
            isEnable = false,
            cornerRadiusInDp = 4f,
            widthInDp = -1f,
            heightInDp = 44f,
            onClickListener = onClickListener
        )
    }
}

@Composable
fun SecondaryButton(
    title: String = "Secondary Button",
    onClickListener: () -> Unit = {}
) {
    MdcTheme {
        Button(
            title = title,
            backgroundColor = Colors.Button.SecondaryBackgroundColor,
            highlightColor = Colors.Button.HighlightSecondaryBackgroundColor,
            disabledColor = Colors.Button.DisableBackgroundColor,
            textColor = Colors.Button.TextColorWhite,
            disableTextColor = Colors.Button.TextColorGray,
            cornerRadiusInDp = 4f,
            widthInDp = -1f,
            heightInDp = 44f,
            onClickListener = onClickListener
        )
    }
}

@Composable
fun PrimaryBorderButton(
    title: String = "Primary Border Button",
    onClickListener: () -> Unit = {}
) {
    MdcTheme {
        Button(
            title = title,
            backgroundColor = Color.White,
            highlightColor = Colors.Button.HighlightPrimaryBorderBackgroundColor,
            disabledColor = Colors.Button.DisableBackgroundColor,
            textColor = Colors.Button.TextColorBlack,
            disableTextColor = Colors.Button.TextColorGray,
            cornerRadiusInDp = 4f,
            widthInDp = -1f,
            heightInDp = 44f,
            borderColor = Color.Black,
            onClickListener = onClickListener
        )
    }
}

@Composable
fun DisablePrimaryBorderButton(
    title: String = "Primary Border Button",
    onClickListener: () -> Unit = {}
) {
    MdcTheme {
        Button(
            title = title,
            backgroundColor = Color.White,
            highlightColor = Colors.Button.HighlightPrimaryBorderBackgroundColor,
            disabledColor = Colors.Button.DisableBackgroundColor,
            textColor = Colors.Button.TextColorBlack,
            disableTextColor = Colors.Button.TextColorGray,
            isEnable = false,
            cornerRadiusInDp = 4f,
            widthInDp = -1f,
            heightInDp = 44f,
            borderColor = Color.Black,
            onClickListener = onClickListener
        )
    }
}

@Composable
fun SecondaryBorderButton(
    title: String = "Secondary Border Button",
    onClickListener: () -> Unit = {}
) {
    MdcTheme {
        Button(
            title = title,
            backgroundColor = Color.White,
            highlightColor = Colors.Button.HighlightSecondaryBorderBackgroundColor,
            disabledColor = Colors.Button.DisableBackgroundColor,
            textColor = Colors.Button.TextColorBlue,
            disableTextColor = Colors.Button.TextColorGray,
            disableBorderColor = Colors.Button.DisableSecondaryBorderColor,
            cornerRadiusInDp = 4f,
            widthInDp = -1f,
            heightInDp = 44f,
            borderColor = Colors.Button.SecondaryBorderColor,
            onClickListener = onClickListener
        )
    }
}

@Composable
fun DisableSecondaryBorderButton(
    title: String = "Disable Secondary Border Button",
    onClickListener: () -> Unit = {}
) {
    MdcTheme {
        Button(
            title = title,
            backgroundColor = Color.White,
            highlightColor = Colors.Button.HighlightSecondaryBorderBackgroundColor,
            disabledColor = Colors.Button.DisableBackgroundColor,
            textColor = Colors.Button.TextColorBlue,
            disableTextColor = Colors.Button.TextColorGray,
            disableBorderColor = Colors.Button.DisableSecondaryBorderColor,
            isEnable = false,
            cornerRadiusInDp = 4f,
            widthInDp = -1f,
            heightInDp = 44f,
            borderColor = Colors.Button.HighlightSecondaryBorderBackgroundColor,
            onClickListener = onClickListener
        )
    }
}