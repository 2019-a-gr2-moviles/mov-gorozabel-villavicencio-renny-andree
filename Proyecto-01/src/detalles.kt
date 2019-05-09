import java.awt.Image
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import javax.swing.*
import javax.swing.filechooser.FileNameExtensionFilter
import control as controlador

class detalles(datos:Registro,accion:String):JFrame("Detalles"){
    init {
        createUI(datos,accion)
    }

    fun createUI(datos:Registro,accion:String):String {


        val panel = JPanel()
        val labelNombre = JLabel("Nombre")
        val labelOrigen = JLabel("Origen")
        val labelClase = JLabel("Clase")
        var imagen = JLabel()
        imagen.setSize(270,180)
        var img:BufferedImage?=null
        try{
            img = ImageIO.read(File(datos.path))
        }catch (e:Exception){
            println(e.message)
        }
        val dimg = img?.getScaledInstance(imagen.width,imagen.height, Image.SCALE_SMOOTH)
        val imageIcon = ImageIcon(dimg)
        imagen= JLabel(imageIcon)




        val fieldNombre = JTextField(datos.nombre)
        val fieldOrigen = JTextField(datos.origen)
        val fieldClase = JTextField(datos.clase)
        val fileButton = JButton("Escoger Imagen")
        val pathImagen = JFileChooser()

        val botonSalir=JButton("Salir")
        val aceptarButton=JButton("Continuar")
        var retorno=""

        pathImagen.dialogTitle = "Seleccione una imagen"
        val imageFilter = FileNameExtensionFilter(
            "Image files", *ImageIO.getReaderFileSuffixes()
        )
        pathImagen.fileFilter = imageFilter

        fileButton.addActionListener {
            pathImagen.showDialog(null, "Escoja la imagen")
        }

        aceptarButton.addActionListener {
            val registro = Registro(
                fieldNombre.text,
                fieldOrigen.text,
                fieldClase.text,
                pathImagen.getCurrentDirectory().toString() + "\\" + pathImagen.selectedFile.name
            )
            retorno = registro.nombre+","+registro.origen+","+registro.clase+","+registro.path
            controlador(retorno,"ActualizarAux",datos.nombre)
            dispose()
        }


        botonSalir.addActionListener {
            dispose()
        }

        if(accion.equals("Consultar") || accion.equals("ConsultarAll")){
            fieldNombre.isEditable = false
            fieldOrigen.isEditable = false
            fieldClase.isEditable = false
            aceptarButton.isVisible=false
            fileButton.isVisible = false
        }


        panel.add(labelClase)
        panel.add(labelNombre)
        panel.add(labelOrigen)
        panel.add(pathImagen)
        panel.add(imagen)
        panel.add(fieldClase)
        panel.add(imagen)
        panel.add(fieldNombre)
        panel.add(fieldOrigen)
        panel.add(aceptarButton)
        panel.add(botonSalir)

        val layout = GroupLayout(panel)
        panel.layout = layout

        layout.setAutoCreateGaps(true)
        layout.setAutoCreateContainerGaps(true)

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imagen)
                        .addComponent(fileButton)
                    )
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNombre)
                        .addComponent(fieldNombre)
                        .addComponent(labelOrigen)
                        .addComponent(fieldOrigen)
                        .addComponent(labelClase)
                        .addComponent(fieldClase)
                    )
                )
                .addComponent(botonSalir)
                .addComponent(aceptarButton)
        )
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(
                    layout.createSequentialGroup()
                        .addGroup(
                            layout.createParallelGroup()
                                .addComponent(imagen)
                                .addComponent(fileButton)
                        )
                        .addGroup(
                            layout.createParallelGroup()
                                .addComponent(labelNombre)
                                .addComponent(fieldNombre)
                                .addComponent(labelOrigen)
                                .addComponent(fieldOrigen)
                                .addComponent(labelClase)
                                .addComponent(fieldClase)
                        )
                )
                .addComponent(botonSalir)
                .addComponent(aceptarButton)

        )
        add(panel)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(450,350)
        setLocationRelativeTo(null)

        return retorno
    }

}

fun mostrarDet(datos: Registro,accion:String){
    val frame = detalles(datos,accion)
    frame.isVisible=true
}