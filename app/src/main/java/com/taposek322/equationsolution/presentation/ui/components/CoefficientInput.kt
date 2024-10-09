package com.taposek322.equationsolution.presentation.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun CoefficientInput(
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes errorMessageId: Int?,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Decimal
        ),
        singleLine = true,
        modifier = modifier,
        isError = errorMessageId!=null,
        supportingText = {
            errorMessageId?.let { 
                Text(text = stringResource(id = it))
            }
        }
    )
}
