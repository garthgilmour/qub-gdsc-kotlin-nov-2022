package org.gdg.belfast.compose.calculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import org.gdg.belfast.compose.calculator.Operation.*

@Composable
fun GDGBelfastTheme(content: @Composable () -> Unit) {
    val colors = MaterialTheme.colors.copy(primary = Color.LightGray)
    MaterialTheme(content = content, colors = colors)
}

@Composable
fun DisplayText(text: String) =
    Text(
        text = text,
        style = TextStyle(color = Color.Black, fontSize = 28.sp),
        modifier = Modifier.padding(all = 10.dp)
    )

@Composable
fun NumberButton(onClick: () -> Unit, number: Int) =
    Button(
        onClick = onClick,
        modifier = Modifier.padding(all = 5.dp)
    ) {
        Text(
            number.toString(),
            style = TextStyle(color = Color.Black, fontSize = 18.sp)
        )
    }

@Composable
fun OperationButton(onClick: () -> Unit, label: String) =
    Button(
        onClick = onClick,
        modifier = Modifier.padding(all = 2.dp)
    ) {
        Text(
            label,
            style = TextStyle(color = Color.Black, fontSize = 14.sp)
        )
    }

@Composable
fun Calculator() {
    val savedTotal = remember { mutableStateOf(0) }
    val displayedTotal = remember { mutableStateOf(0) }
    val operationOngoing = remember { mutableStateOf(Operation.None) }
    val operationJustChanged = remember { mutableStateOf(false) }

    val numberSelected = { num: Int ->
        when {
            operationJustChanged.value -> {
                operationJustChanged.value = false
                savedTotal.value = displayedTotal.value
                displayedTotal.value = num
            }
            displayedTotal.value == 0 -> {
                displayedTotal.value = num
            }
            else -> {
                displayedTotal.value = (displayedTotal.value * 10) + num
            }
        }
    }

    val clearSelected = {
        displayedTotal.value = 0
        savedTotal.value = 0
        operationOngoing.value = Operation.None
        operationJustChanged.value = false
    }

    val doOperation = {
        val saved = savedTotal.value
        val displayed = displayedTotal.value

        when (operationOngoing.value) {
            Add -> displayedTotal.value = saved + displayed
            Subtract -> displayedTotal.value = saved - displayed
            Multiply -> displayedTotal.value = saved * displayed
            Divide -> displayedTotal.value = saved / displayed
            else -> throw IllegalStateException("No operation to execute!")
        }
    }

    val operationSelected = { op: Operation ->
        operationJustChanged.value = true
        if (operationOngoing.value != None) {
            doOperation()
            savedTotal.value = displayedTotal.value
        }
        operationOngoing.value = op
    }

    val equalsSelected = {
        doOperation()
        operationOngoing.value = Operation.None
    }

    GDGBelfastTheme {
        Column {
            Row {
                DisplayText(text = "${displayedTotal.value}")
            }
            Row {
                Column {
                    Row {
                        (1..3).forEach { num ->
                            NumberButton(onClick = { numberSelected(num) }, number = num)
                        }
                    }
                    Row {
                        (4..6).forEach { num ->
                            NumberButton(onClick = { numberSelected(num) }, number = num)
                        }
                    }
                    Row {
                        (7..9).forEach { num ->
                            NumberButton(onClick = { numberSelected(num) }, number = num)
                        }
                    }
                    Row {
                        NumberButton(onClick = { numberSelected(0) }, number = 0)
                    }
                }
                Column {
                    listOf(
                        { operationSelected(Add) } to "+",
                        { operationSelected(Subtract) } to "-",
                        { operationSelected(Multiply) } to "*",
                        { operationSelected(Divide) } to "/",
                        clearSelected to "Clear",
                        equalsSelected to "="
                    ).forEach {
                        OperationButton(onClick = it.first, label = it.second)
                    }
                }
            }
        }
    }
}

