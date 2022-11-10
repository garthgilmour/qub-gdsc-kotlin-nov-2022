package org.gdg.belfast.compose.calculator

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() {
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Calculator via Compose for Desktop",
            state = rememberWindowState().apply {
                size = DpSize(Dp(350f), Dp(400f))
            }
        ) {
            Calculator()
        }
    }
}
