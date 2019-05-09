import java.io.BufferedReader
import java.io.File
import java.io.FileFilter
import java.io.FileReader
import javax.*
import javax.imageio.ImageIO
import javax.swing.*
import javax.swing.filechooser.FileNameExtensionFilter
import control as controlador

class JOptionPaneMultiInput(action:String,aConsultar:String):JFrame() {

    init {
        var tipo:String
        var accion=action
        if (action.equals("ConsultarAll")){
            tipo=""
            accion=action
        }
        else if(action.equals("Consultar")){
            tipo=aConsultar
            accion=action
        }else{
            tipo = createUI(action)
            println(tipo)
            println(action)
            if(tipo.equals(""))
            accion=action
        }
        controlador(tipo,accion)
    }

    fun createUI(action: String):String {
        val nombreF = JTextField(10)
        val origenF = JTextField(10)
        val estatF = JTextField(10)
        val fileButton = JButton("Escoger Imagen")
        val pathImagen = JFileChooser()

        pathImagen.dialogTitle = "Seleccione una imagen"
        val imageFilter = FileNameExtensionFilter(
            "Image files", *ImageIO.getReaderFileSuffixes()
        )
        pathImagen.fileFilter = imageFilter

        fileButton.addActionListener {
            pathImagen.showDialog(null, "Escoja la imagen")
        }


        val myPanel = JPanel()
        myPanel.add(JLabel("Nombre: "))
        myPanel.add(nombreF)
        myPanel.add(Box.createHorizontalStrut(15)) // a spacer
        myPanel.add(JLabel("Origen: "))
        myPanel.add(origenF)
        myPanel.add(Box.createHorizontalStrut(15)) // a spacer
        myPanel.add(JLabel("Clase: "))
        myPanel.add(estatF)
        myPanel.add(Box.createHorizontalStrut(15))
        myPanel.add(JLabel("Imagen: "))
        myPanel.add(fileButton)

        add(myPanel)

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(400, 200)
        setLocationRelativeTo(null)

        val result = JOptionPane.showConfirmDialog(
            null, myPanel,
            "Por favor, ingrese los datos solicitados", JOptionPane.OK_CANCEL_OPTION
        )
        if (result == JOptionPane.OK_OPTION) {
            val registro = Registro(
                nombreF.text,
                origenF.text,
                estatF.text,
                pathImagen.getCurrentDirectory().toString() + "\\" + pathImagen.selectedFile.name
            )
            return registro.nombre+","+registro.origen+","+registro.clase+","+registro.path
        }else if(result== JOptionPane.CANCEL_OPTION)
            return ""
        return ""
    }
}

fun regAct(action:String,aConsultar:String ="Todos") {
    val frame = JOptionPaneMultiInput(action,aConsultar)
}