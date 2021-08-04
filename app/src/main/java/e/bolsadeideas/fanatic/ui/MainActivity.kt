package e.bolsadeideas.fanatic.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import e.bolsadeideas.fanatic.learningfragments.AuxActivity
import e.bolsadeideas.fanatic.R
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class MainActivity : AppCompatActivity() {

    private lateinit var texto: TextView
//    private val carousel: ImageCarousel = findViewById(R.id.carousel)
    private val list = mutableListOf<CarouselItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val carousel: ImageCarousel = findViewById(R.id.carousel)

        list.add(CarouselItem("https://www.motor.com.co/files/article_main/files/crop/uploads/2018/03/20/5ab173f821f49.r_1521580181051.149-223-869-583.jpeg", "Toyota"))
        list.add(CarouselItem("https://autosdeprimera.com/v2/wp-content/uploads/2020/09/audi-q5-sportback-2020-a.jpg", "Audi"))
        list.add(CarouselItem("https://img.motor16.com/modelos/land-rover-range-rover-evoque.jpg", "Land Rover"))
        carousel.addData(list)

        carousel.carouselListener = object: CarouselListener{
            override fun onClick(position: Int, carouselItem: CarouselItem) {
                Toast.makeText(applicationContext, "Auto: ${carouselItem.caption}", Toast.LENGTH_LONG).show()
            }
        }



//        texto = findViewById<TextView>(R.id.txt_output)
//        val boton = findViewById<Button>(R.id.btnMain)

//        boton.setOnClickListener {
////            texto.setText("Hola Crack")
//            navegarSegundaActivity()
//        }

//        ---------Using Fragment Manager------------
//        supportFragmentManager.commit {
//            setReorderingAllowed(true)
//            add(R.id.fragment_container_view, FirstFragment())
//        }
    }

    private fun navegarSegundaActivity(){
        val intent = Intent(this, AuxActivity::class.java )
        intent.putExtra("nombre", "Curso de Android")
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode){
            1 -> {
                if(resultCode == Activity.RESULT_OK){
                    texto.text = data?.getStringExtra("nombre2") ?: "Sin datos"
                }
            }
        }
    }
}