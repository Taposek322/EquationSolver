package com.taposek322.equationsolution.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.taposek322.equationsolution.R
import com.taposek322.equationsolution.domain.SolutionState
import com.taposek322.equationsolution.presentation.ui.components.EquationFormula
import com.taposek322.equationsolution.presentation.viewmodel.SolutionViewModel

@Composable
fun SolutionScreen(
    viewModel: SolutionViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        val solutionState = viewModel.coeficients.collectAsState()

        var coefficients by rememberSaveable {
            mutableStateOf(listOf<String>("1", "-2", "1"))
        }

        var isInputError by rememberSaveable {
            mutableStateOf(false)
        }

        EquationFormula(
            coefficient = coefficients,
            onCoefficentChanged = { index, value ->
                coefficients = coefficients.toMutableList().apply {
                    this[index] = value
                }
            },
            isInputError
        )
        Button(
            onClick = {
                coefficients.let { list ->
                    val isAllCoefficientNotEmpty = list.all { it.isNotEmpty() }
                    if (isAllCoefficientNotEmpty) {
                        isInputError = false
                        viewModel.solve(list[0].toInt(), list[1].toInt(), list[2].toInt())
                    } else {
                        isInputError = true
                    }
                }
            }
        ) {
            Text(text = stringResource(id = R.string.solve_button))
        }
        Text(
            text = when (val solution = solutionState.value ) {
                is SolutionState.TWO_SOLUTION -> {
                    stringResource(
                        id = R.string.two_solution,
                        solution.x1,
                        solution.x2
                    )
                }
                is SolutionState.ONE_SOLUTION -> stringResource(id = R.string.one_solution, solution.x)
                is SolutionState.NO_SOLUTION -> stringResource(id = R.string.no_solution)
                null -> ""
            }
        )

    }
}
