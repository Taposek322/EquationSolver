package com.taposek322.equationsolution.data

import com.taposek322.equationsolution.domain.SolutionState
import kotlin.math.sqrt

object SolutionSolver {
    fun solve(a:Int, b: Int, c:Int): SolutionState {
        val discr = b*b - 4*a*c
        return when {
            discr < 0 -> SolutionState.NO_SOLUTION
            discr == 0 -> {
                val x = (-b/(2*a)).toDouble()
                SolutionState.ONE_SOLUTION(x)
            }
            else -> {
                val x1 = ((-b+sqrt(discr.toDouble()))/(2*a))
                val x2 = ((-b-sqrt(discr.toDouble()))/(2*a))
                SolutionState.TWO_SOLUTION(x1, x2)
            }
        }
    }
}