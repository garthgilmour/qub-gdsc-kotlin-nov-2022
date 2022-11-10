package oo.expressions

import java.awt.FlowLayout
import java.awt.event.MouseEvent
import java.awt.event.MouseMotionListener
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JTextField

class MyGui : JFrame("Simple Gui") {
    private val button: JButton = JButton("Push Me")
    private val textField: JTextField = JTextField(10)

    init {
        setLayout()
        setEventHandling()
    }
    private fun setEventHandling() {
        button.addActionListener({ textField.text = "Button Pushed!" })
        button.addMouseMotionListener(object : MouseMotionListener {
            override fun mouseMoved(e: MouseEvent?) {
                println("Mouse moved to ${e?.x}, ${e?.y}")
            }
            override fun mouseDragged(e: MouseEvent?) {
                println("Mouse dragged to ${e?.x}, ${e?.y}")
            }
        })
    }
    private fun setText(text: Any) {
        textField.text = text.toString()
    }
    private fun setLayout() {
        defaultCloseOperation = EXIT_ON_CLOSE
        layout = FlowLayout()
        add(button)
        add(textField)
        pack()
    }
}
