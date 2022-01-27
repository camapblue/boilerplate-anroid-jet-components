package ptc.tech.jet_components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ptc.tech.jet_components.theme.Colors

@Composable
private fun TextFieldComponent(
    label: String,
    text: String? = null,
    hint: String? = null,
    isEnable: Boolean = true,
    focusBorderColor: Color = Colors.TextField.focusBorderColor,
    borderColor: Color = Colors.TextField.borderColor,
    isError: Boolean = false,
    errorMessage: String? = null,
    errorColor: Color = Colors.TextField.errorColor,
    disableBackgroundColor: Color = Colors.TextField.disableBackgroundColor,
    widthInDp: Float? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailing: @Composable (() -> Unit)? = null
) {
    val inputValue = remember { mutableStateOf(if (text == null) TextFieldValue() else TextFieldValue(text)) }
    val interactionSource = remember { MutableInteractionSource() }
    val isFocusedState by interactionSource.collectIsFocusedAsState()

    val disableBorder = BorderStroke(1.dp, borderColor)
    val errorBorder = BorderStroke(2.dp, errorColor)
    val focusBorder = BorderStroke(2.dp, focusBorderColor)
    val unfocusBorder = BorderStroke(1.dp, borderColor)

    val modifierBorder: Modifier = Modifier
        .background(
            shape = RoundedCornerShape(4.dp),
            color = if (isEnable) Color.Transparent else disableBackgroundColor
        )
        .border(
            shape = RoundedCornerShape(4.dp),
            border = if (!isEnable) {
                disableBorder
            } else if (isError) {
                errorBorder
            } else if (isFocusedState) {
                focusBorder
            } else {
                unfocusBorder
            }
        )

    Column {
        TextField(
            interactionSource = interactionSource,
            value = inputValue.value,
            onValueChange = {
                inputValue.value = it
            },
            textStyle = TextStyle(
                color = if (isEnable) Colors.TextField.textColor else Colors.TextField.disableTextColor,
                fontSize = 16.sp
            ),
            label = {
                Text(text = label, fontSize = 12.sp, color = Color(0xFF45484A))
            },
            placeholder = {
                if (hint != null) {
                    Text(text = hint, fontSize = 12.sp, color = Color(0xFF45484A))
                }
            },
            shape = RoundedCornerShape(4.dp),
            singleLine = true,
            maxLines = 1,
            trailingIcon = trailing,
            isError = isError,
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                backgroundColor = Color.Transparent,
            ),
            enabled = isEnable,
            visualTransformation = visualTransformation,
            modifier = Modifier
                .then(
                    if (widthInDp != null) {
                        if (widthInDp < 0) {
                            Modifier.fillMaxWidth()
                        } else {
                            Modifier.width(widthInDp.dp)
                        }
                    } else {
                        Modifier
                    }
                )
                .then(modifierBorder)
        )

        if (isError && errorMessage != null) {
            Text(text = errorMessage, fontSize = 12.sp, modifier = Modifier.padding(top = 8.dp), color = errorColor)
        }
    }
}


@Composable
fun NormalText(
    label: String,
    text: String? = null,
    hint: String? = null,
    isEnable: Boolean = true,
    isError: Boolean = false,
    errorMessage: String? = null
) {
    TextFieldComponent(
        label = label,
        text = text,
        hint = hint,
        isEnable = isEnable,
        isError = isError,
        errorMessage = errorMessage,
        widthInDp = -1f
    )
}


@Composable
fun CameraText(
    label: String,
    text: String? = null,
    hint: String? = null,
    isEnable: Boolean = true,
    isError: Boolean = false,
    errorMessage: String? = null
) {
    TextFieldComponent(
        label = label,
        text = text,
        hint = hint,
        isEnable = isEnable,
        isError = isError,
        errorMessage = errorMessage,
        widthInDp = -1f,
        trailing = {
            Icon(painterResource(R.drawable.ic_camera), contentDescription = "camera")
        }
    )
}

@Composable
fun PasswordText(
    text: String? = null,
    isEnable: Boolean = true,
    isError: Boolean = false,
    errorMessage: String? = null
) {
    val passwordVisibility = remember { mutableStateOf(false) }

    TextFieldComponent(
        label = "Password",
        text = text,
        hint = "Enter password",
        isEnable = isEnable,
        isError = isError,
        errorMessage = errorMessage,
        widthInDp = -1f,
        trailing = {
            Row(modifier = Modifier
                .fillMaxHeight()
                .clickable {
                    passwordVisibility.value = !passwordVisibility.value
                },
                verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
                Text(text = "Show", color = Color(0xFF808285), fontSize = 12.sp, modifier = Modifier.padding(start = 8.dp, end = 16.dp))
            }
        },
        visualTransformation = if (passwordVisibility.value) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}