import java.awt.BorderLayout
import java.awt.Dimension
import java.util.*
import javax.swing.*
import javax.swing.table.*
import javax.swing.table.DefaultTableModel



class tablaC(action:String,data:String):JFrame(){

    init {
        createUI(action,data)
    }

    private fun createUI(action:String,data:String){
        val names = arrayListOf<String>("Nombre","Origen","Estatura","Path")
        val lista=data.split("\n")
        val table = JTable()
        table.setDefaultEditor(Any::class.java, null)

        val scrollPane = JScrollPane(table)
        scrollPane.horizontalScrollBarPolicy = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS
        scrollPane.verticalScrollBarPolicy = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS


        val label = JLabel(action)
        val labelH = JLabel("Nombre                     Origen                     Estatura                     Path")

        val botonMostrar=JButton("Detalles")
        val botonRegresar = JButton("Regresar")

        botonMostrar.addActionListener {
            var totalRow=table.rowCount-1;
            if(action.equals("Consultar") || action.equals("Actualizar")){
                totalRow+=1
            }
            if(table.selectedRow==-1 || table.selectedRow==totalRow)
                JOptionPane.showMessageDialog(null,"Seleccione un Registro valido para ver los detalles")
            else{
                var column = 0
                val seleccionado=ArrayList<String>()
                val row = table.selectedRow
                var value:String
                while(column<table.columnCount){
                    value=table.model.getValueAt(row,column++).toString()
                    seleccionado.add(value)
                    println(value)
                }
                val registro=Registro(seleccionado.get(0),seleccionado.get(1),seleccionado[2],seleccionado[3])

                mostrarDet(registro,action)
                dispose()
            }


        }
        botonRegresar.addActionListener {
            dispose()
        }

        var model=DefaultTableModel()

        val columns = arrayOf<Any>("Nombre","Origen","Estatura","Path")
        model.setColumnIdentifiers(columns)
        lista.forEach {
            val registros = it.split(",").stream().toArray()
            model.addRow(registros)
            }

        table.model = model


        val myPanl = JPanel()
        myPanl.layout = null
        myPanl.setSize(450,450)

        label.setBounds(10,0,100,20)
        labelH.setBounds(10,30,400,10)
        table.setBounds(10,45,400,150)
        table.preferredSize = Dimension(400,150)

        botonMostrar.setBounds(70,200,120,50)
        botonRegresar.setBounds(240,200,120,50)

        myPanl.add(label)
        myPanl.add(labelH)
        myPanl.add(table)
        add(scrollPane,BorderLayout.CENTER)
        myPanl.add(botonMostrar)
        myPanl.add(botonRegresar)

        add(myPanl)

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(450,300)
        setLocationRelativeTo(null)

    }
}
fun consultar(registro:String,action:String){
    val frame = tablaC(action,registro)
    frame.isVisible = true
}