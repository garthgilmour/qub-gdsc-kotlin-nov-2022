package functions.and.closures

import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JTextField

class MyGui : JFrame("Simple Gui") {
    private val button1: JButton = JButton("Foo")
    private val button2: JButton = JButton("Bar")
    private val button3: JButton = JButton("Zed")
    private val textField: JTextField = JTextField(10)

    init {
        setLayout()
        setEventHandling()
    }

    private fun setEventHandling() {
        var x = 0
        button1.addActionListener { setText(x++) }
        button2.addActionListener { setText(x++) }
        button3.addActionListener { setText(x++) }
    }

    private fun setText(text: Any) {
        textField.text = text.toString()
    }

    private fun setLayout() {
        defaultCloseOperation = EXIT_ON_CLOSE
        layout = GridLayout(4, 1)
        add(textField)
        add(button1)
        add(button2)
        add(button3)
        pack()
    }
}