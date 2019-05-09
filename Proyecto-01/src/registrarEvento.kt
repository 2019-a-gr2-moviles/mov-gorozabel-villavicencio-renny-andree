
import java.awt.SystemColor.control
import javax.swing.*
import controlEvento as controlador

class registrarEvento():JFrame() {

    init {
        val nuevoEvento=createUI()
        controlador(nuevoEvento,"Registro")

    }

    fun createUI(): String{
        val nombreF = JTextField(10)
        val fechaF = JTextField(10)
        val bonusF = JTextField(10)
        val bonus2F = JTextField(10)



        val myPanel = JPanel()
        myPanel.add(JLabel("Nombre: "))
        myPanel.add(nombreF)
        myPanel.add(Box.createHorizontalStrut(15)) // a spacer
        myPanel.add(JLabel("Fecha "))
        myPanel.add(fechaF)
        myPanel.add(Box.createHorizontalStrut(15)) // a spacer
        myPanel.add(JLabel("ServantBonus1 "))
        myPanel.add(bonusF)
        myPanel.add(Box.createHorizontalStrut(15))
        myPanel.add(JLabel("ServantBonus2 "))
        myPanel.add(bonus2F)

        add(myPanel)

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(400, 200)
        setLocationRelativeTo(null)

        val result = JOptionPane.showConfirmDialog(
            null, myPanel,
            "Por favor, ingrese los datos solicitados", JOptionPane.OK_CANCEL_OPTION
        )
        if (result == JOptionPane.OK_OPTION) {
            val array = arrayListOf<String>(bonusF.text,bonus2F.text)
            val registro = Evento(
                nombreF.text,
                fechaF.text,
                array
            )
            return registro.nombre+","+registro.fecha+","+registro.servantsBonus[0]+","+registro.servantsBonus[1]
        }
        return ""
    }
}

fun regEvent() {
    val frame = registrarEvento()
}