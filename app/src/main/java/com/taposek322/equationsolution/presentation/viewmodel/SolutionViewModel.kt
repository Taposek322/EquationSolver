package com.taposek322.equationsolution.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.taposek322.equationsolution.data.SolutionSolver
import com.taposek322.equationsolution.domain.SolutionState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SolutionViewModel: ViewModel() {
    private val _coeficients: MutableStateFlow<SolutionState?> = MutableStateFlow<SolutionState?>(null)
    val coeficients: StateFlow<SolutionState?> = _coeficients.asStateFlow()

    fun solve(a: Int, b: Int, c:Int) {
        _coeficients.update {
            SolutionSolver.solve(a, b, c)
        }
    }
}
