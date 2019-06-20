package com.example.pinterest

import android.app.AlertDialog
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lista = arrayListOf<Imagenes>()
        val recycler_view=rv_example
        val activity = this


        lista.add(Imagenes("Illidan",
            R.drawable.i01,
            "Illidan Tempestira fue el autoproclamado Señor de Terrallende , que gobernó desde el Templo Oscuro. Illidan nació como un un elfo de la noche, y, en palabras de Maiev Shadowsong \"no es un demonio ni un elfo de la noche, sino algo más\". Es el hermano gemelo de Malfurion, y, al igual que él, siempre estuvo enamorado de Tyrande Whisperwind . Es difícil clasificar todos sus poderes, por el hecho de que el aprendió muchos hechizos siendo cazador de demonios, hechicero, y habiendo recibido los poderes de La Calavera de Gul'dan",
            false))
        lista.add(Imagenes("Saber Alter",
            R.drawable.i02,
            "Saber Alter (セイバー・オルタナティブ, Seibā Orutanatibu?, lit. Saber Alternativa) es la servant de clase saber de Sakura Matou en la Quinta Guerra del Santo Grial de la ruta Heaven's Feel de Fate/stay night. Es una versión cambiada de Saber después de haber sido consumida y corrompida por el Santo Grial Sombra. Ella es uno de los servants del Protagonista en los conflictos de Grand Order de Fate/Grand Order tanto como servant de clase saber como servant de clase rider con atributos de Santa.",
            false))
        lista.add(Imagenes("Oda Nobunaga",
            R.drawable.i03,
            "Ella es Oda Nobunaga, El Rey Demonio del Sexto Cielo. Uno de los tres unificadores de Japón, conocido por su crueldad y por negar a todo divinidad como verdadera.",
            false))
        lista.add(Imagenes("Neeko",
            R.drawable.i04,
            "Proveniente de una tribu vastaya perdida desde hace mucho tiempo, Neeko puede mezclarse en cualquier multitud adoptando la apariencia de los demás e incluso absorber un poco de su estado emocional para distinguir a un amigo de un enemigo en tan solo un instante.",
            false))
        lista.add(Imagenes("Jaina",
            R.drawable.i05,
            "Jaina Valiente es la hechicera humana viva más poderosa de la actualidad. Pertenece al linaje de la Casa Valiente cuyos progenitores Daelin y Katherine han servido como gobernantes del reino humano de Kul Tiras."
        ,false))
        lista.add(Imagenes("Riven",
            R.drawable.i06,"Hace tiempo, fue una guerrera en las huestes de Noxus, pero hoy, Riven está exiliada en una tierra que alguna vez intentó conquistar. Alcanzó un alto rango gracias a la fuerza de su convicción y a su brutal eficiencia, por lo que fue recompensada con una espada rúnica legendaria y con un batallón propio.",
            false))
        lista.add(Imagenes("Sakata Kintoki",
            R.drawable.i07,
            " Sirvió de criado para el samurái Minamoto no Yorimitsu y se hizo famoso por sus dotes de guerrero. Sin embargo su leyenda ha cambiado y aumentado con el tiempo.",
            false))
        lista.add(Imagenes("Jaina2",
            R.drawable.i08,
            "2Jaina Valiente es la hechicera humana viva más poderosa de la actualidad. Pertenece al linaje de la Casa Valiente cuyos progenitores Daelin y Katherine",
            false))
        lista.add(Imagenes("Zoe",
            R.drawable.i09,
            "Como la personificación de las travesuras, la imaginación y el cambio, Zoe actúa como la mensajera cósmica de Targón y anuncia grandes acontecimientos que pueden alterar mundos. Su mera presencia distorsiona las matemáticas arcanas que rigen las realidades; en ocasiones, sin ser consciente de su poder, provoca todo tipo de cataclismos.Tal vez eso explique la actitud indiferente con la cual Zoe \"cumple\" con su deber.",
            false))
        lista.add(Imagenes("Varian",
            R.drawable.i10,
            "Varian Wrynn, también conocido como Lo'Gosh el \"Lobo Fantasmal\", es el hijo del fallecido rey Llane Wrynn y antiguo rey de Ventormenta.[4] Bajo su mandato, los humanos de Ventormenta llevaron a la Alianza a la victoria contra el Rey Exánime en Rasganorte y se enfrentó a la Horda de Garrosh Grito Infernal durante los años de conflicto.",
            false))

        val objeto:Imagenes? = this.intent.getParcelableExtra<Imagenes>("imagen")
        val posicion = this.intent.getIntExtra("posicion",-1)

        if(posicion!=-1)
            lista[posicion].like=objeto!!.like

        iniciarRV(lista,this,recycler_view)
    }

    fun iniciarRV(
        lista:List<Imagenes>,
        actividad:MainActivity,
        recyclerView: RecyclerView
    ){
        val adaptador = AdaptadorImagenes(
            lista,
            actividad,
            recyclerView
        )
        recyclerView.adapter = adaptador
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.layoutManager = GridLayoutManager(actividad,2)

        adaptador.notifyDataSetChanged()
    }

    override fun onBackPressed() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Exit Application?")
        alertDialogBuilder
            .setMessage("Click yes to exit!")
            .setCancelable(false)
            .setPositiveButton("Yes",
                DialogInterface.OnClickListener { dialog, id ->
                    moveTaskToBack(true)
                    android.os.Process.killProcess(android.os.Process.myPid())
                    System.exit(1)
                })

            .setNegativeButton("No", DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }




}
