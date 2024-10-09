package com.taposek322.equationsolution.domain

sealed interface SolutionState {
    data class TWO_SOLUTION(
        val x1: Double,
        val x2: Double
    ): SolutionState

    data class ONE_SOLUTION(
        val x: Double
    ): SolutionState

    data object NO_SOLUTION: SolutionState
}