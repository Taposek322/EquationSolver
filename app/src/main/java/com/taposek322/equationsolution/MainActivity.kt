package com.taposek322.equationsolution

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.taposek322.equationsolution.presentation.ui.SolutionScreen
import com.taposek322.equationsolution.presentation.ui.theme.EquationSolutionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EquationSolutionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SolutionScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
