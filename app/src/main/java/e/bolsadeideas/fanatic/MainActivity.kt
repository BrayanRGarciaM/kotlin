package e.bolsadeideas.fanatic

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    private lateinit var texto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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