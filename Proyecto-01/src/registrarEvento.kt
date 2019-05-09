
import java.awt.SystemColor.control
import javax.swing.*
import controlEvento as controlador

class registrarEvento(action: String,aCons: String):JFrame() {

    init {
        var tipo:String
        var accion=""
        if (action.equals("ConsultarAll")){
            tipo=""
            accion=action
        }
        else if(action.equals("Consultar")){
            tipo=aCons
            accion=action
        }else{
            tipo = createUI(action)
            println(tipo)
            accion=action
        }
        controlador(tipo,accion)

    }

    fun createUI(action: String): String{
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
        }else if ( result == JOptionPane.CANCEL_OPTION)
            dispose()
        return ""
    }
}

fun regEvent(action:String,aCons:String = "Todos") {
    val frame = registrarEvento(action,aCons)
}