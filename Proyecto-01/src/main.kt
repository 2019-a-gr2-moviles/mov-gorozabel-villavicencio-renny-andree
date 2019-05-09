import java.awt.EventQueue
import java.awt.Image
import java.awt.event.KeyEvent
import javax.swing.*
import javax.swing.JOptionPane.QUESTION_MESSAGE
import regAct as regAct
import control as controlador

class MenuPrincipal(titulo:String):JFrame(){
    init{
        createUI(titulo)
    }
    private fun createUI(titulo:String){
        title = titulo
        createMenuBar()

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(400,300)
        setLocationRelativeTo(null)
    }

    private fun createMenuBar(){
        val menuBar = JMenuBar()


        // Consultar
        var iSearch = ImageIcon("src\\resources\\search\\search.png")
        var iSearchAll = ImageIcon("src\\resources\\search\\searchAll.png")
        iSearch = convertIcon(iSearch)
        iSearchAll = convertIcon(iSearchAll)

        val file = JMenu("Consultar")
        file.mnemonic = KeyEvent.VK_1

        val eMenuItem = JMenuItem("Consultar todos",iSearchAll)
        eMenuItem.mnemonic = KeyEvent.VK_2
        eMenuItem.toolTipText = "Consultar todos los Registros"
        eMenuItem.addActionListener{
            regAct(
                "ConsultarAll"
            )
            //JOptionPane.showMessageDialog(null,"Aqui saldria la info")
        }
        val fileItem = JMenuItem("Consultar",iSearch)
        fileItem.mnemonic = KeyEvent.VK_1
        fileItem.toolTipText = "Consulta un registro por nombre"
        fileItem.addActionListener{
            val aConsultar = JOptionPane.showInputDialog(null,"Ingrese el Nombre del Personaje que desea buscar","Consulta",QUESTION_MESSAGE)
            regAct("Consultar",aConsultar)
        }

        file.add(fileItem)
        file.add(eMenuItem)

        // Registrar
        var iReg = ImageIcon("src\\resources\\registrar\\reg.png")
        iReg = convertIcon(iReg)

        val reg = JMenu("Registrar")
        reg.mnemonic = KeyEvent.VK_2

        val regItem = JMenuItem("Registrar",iReg)
        regItem.mnemonic = KeyEvent.VK_2
        regItem.toolTipText = "Registrar un nuevo personaje"
        regItem.addActionListener{
            //busqueda("Registrar","Registrar nuevo personaje","Registrar")
            regAct("Registro")
            //JOptionPane.showMessageDialog(null,"Aqui saldria una tabla pa registrar el personaje")
        }

        reg.add(regItem)

        // Actualizar

        var iUpdate = ImageIcon("src\\resources\\update\\update.png")
        iUpdate = convertIcon(iUpdate)

        val upd = JMenu("Actualizar")
        upd.mnemonic = KeyEvent.VK_3

        val updateItem = JMenuItem("Actualizar",iUpdate)
        updateItem.mnemonic = KeyEvent.VK_1
        updateItem.toolTipText = "Actualiza un Registro"
        updateItem.addActionListener{
            controlador("None","Actualizar")
        }

        upd.add(updateItem)

        // Eliminar

        var iDelete = ImageIcon("src\\resources\\delete\\delete.png")
        var iDeleteAll = ImageIcon("src\\resources\\delete\\deleteAll.png")
        iDelete = convertIcon(iDelete)
        iDeleteAll = convertIcon(iDeleteAll)

        val delt = JMenu("Eliminar")
        delt.mnemonic = KeyEvent.VK_4

        val deltItem1 = JMenuItem("Eliminar todos",iDeleteAll)
        deltItem1.mnemonic = KeyEvent.VK_2
        deltItem1.toolTipText = "Eliminar todos los Registros"
        deltItem1.addActionListener{
            if(JOptionPane.showConfirmDialog(
                    null, "¿Desea eliminar todos los registros?",
                    "Eliminar Todos", JOptionPane.OK_CANCEL_OPTION
                )==JOptionPane.OK_OPTION)
                controlador("Eliminar","EliminarTodo")
        }
        val deltItem = JMenuItem("Eliminar",iDelete)
        deltItem.mnemonic = KeyEvent.VK_1
        deltItem.toolTipText = "Elimina un registro por nombre"
        deltItem.addActionListener{
            controlador("Eliminar","Eliminar")
        }

        delt.add(deltItem)
        delt.add(deltItem1)

        // Eventos

        var iEvento = ImageIcon("src\\resources\\evento\\new.jpg")
        var iEventoDel = ImageIcon("src\\resources\\evento\\delete.png")
        iEvento = convertIcon(iEvento)
        iEventoDel = convertIcon(iEventoDel)

        val event = JMenu("Eventos")
        delt.mnemonic = KeyEvent.VK_5

        val event1 = JMenuItem("Nuevo Evento",iEvento)
        event1.mnemonic = KeyEvent.VK_1
        event1.toolTipText = "Registra un nuevo evento"
        event1.addActionListener{
            regEvent()
        }
        val event2 = JMenuItem("Eliminar evento",iEventoDel)
        event2.mnemonic = KeyEvent.VK_2
        event2.toolTipText = "Elimina un evento"
        event2.addActionListener{
            controlador("Eliminar","Eliminar")
        }

        event.add(event1)
        event.add(event2)



        menuBar.add(file)
        menuBar.add(reg)
        menuBar.add(upd)
        menuBar.add(delt)
        menuBar.add(event)

        jMenuBar = menuBar
    }

    private fun convertIcon(icon : ImageIcon):ImageIcon{
        val imagenAux = icon.image.getScaledInstance(20,20,java.awt.Image.SCALE_SMOOTH);
        val ic = ImageIcon(imagenAux)
        return ic
    }
}

private fun createAndShowGUI(){
    val frame = MenuPrincipal("Menu Principal")
    frame.isVisible = true
}

fun main(args : Array<String>){
    EventQueue.invokeLater(::createAndShowGUI)
}