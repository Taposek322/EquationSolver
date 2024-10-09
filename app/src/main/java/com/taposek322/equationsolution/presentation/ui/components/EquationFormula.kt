package com.taposek322.equationsolution.presentation.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.taposek322.equationsolution.R

@Composable
fun EquationFormula(
    coefficient: List<String>,
    onCoefficentChanged: (Int, String)->Unit,
    isError: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        CoefficientInput(
            value = coefficient[0],
            onValueChange = { coef -> onCoefficentChanged(0, coef)},
            errorMessageId = if(isError && coefficient[2].isEmpty()) R.string.empty_coefficient_error_message else null,
            modifier = modifier
                .weight(1f)
        )
        Text(text = "x^2 +")
        CoefficientInput(
            value = coefficient[1],
            onValueChange = { coef -> onCoefficentChanged(1, coef)},
            errorMessageId = if(isError && coefficient[1].isEmpty()) R.string.empty_coefficient_error_message else null,
            modifier = modifier
                .weight(1f)
        )
        Text(
            text = "x +")
        CoefficientInput(
            value = coefficient[2],
            onValueChange = { coef -> onCoefficentChanged(2, coef)},
            errorMessageId = if(isError && coefficient[2].isEmpty()) R.string.empty_coefficient_error_message else null,
            modifier = modifier
                .weight(1f)
        )
        Text(text = " = 0")
    }
}

@Preview
@Composable
private fun EquationFormula_NoError_Preview() {
    EquationFormula(
        listOf("1","-2","1"),
        onCoefficentChanged =  {_,_ -> },
        false
    )
}

@Preview
@Composable
private fun EquationFormula_Error_Preview() {
    EquationFormula(
        listOf("1","","1"),
        onCoefficentChanged =  {_,_ -> },
        true
    )
}
