package e.bolsadeideas.fanatic.learningfragments

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import e.bolsadeideas.fanatic.R

class AuxActivity : AppCompatActivity() {

    private var nombre: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aux)

        val texto = findViewById<TextView>(R.id.txt_aux_output)
        val button = findViewById<Button>(R.id.btnAux)

        button.setOnClickListener {
            navegarSegundaActivity()
        }
        intent.extras?.let { bundle ->
           nombre = bundle.getString("nombre")
        }

        texto.text = nombre
    }

    private fun navegarSegundaActivity(){
        val intent = Intent()
        intent.putExtra("nombre2", "Curso de Android")
        setResult(Activity.RESULT_OK, intent )
        finish()
    }
}