package e.bolsadeideas.fanatic.learningfragments

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import e.bolsadeideas.fanatic.R

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment(R.layout.fragment_second) {

    private var nombre: String? = ""
    private var edad: Int? = 0
    private val args: SecondFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        nombre = arguments?.getString(MI_NOMBRE)
//        edad = arguments?.getInt(MI_EDAD)

//        Using Safe Args
        nombre = args.nombre
        edad = args.edad

//        Using Manager fragments or Navigation
//        arguments?.let { bundle ->
//            nombre = bundle.getString(MI_NOMBRE)
//            edad = bundle.getInt(MI_EDAD)
//        }

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val txtView = view.findViewById<TextView>(R.id.txtViewFragm2)
        txtView.text = "$nombre $edad"
        val btnResultado = view.findViewById<Button>(R.id.btnFragm2SetResultFragment)
        btnResultado.setOnClickListener {
            setFragmentResult("requestKeyFragment", bundleOf("bundleKey" to "$nombre $edad"))
//            Using DeepLinking
//            val action = SecondFragmentArgs.
            findNavController().navigate(Uri.parse("fanatic://card"))
        }
    }

    companion object {
        private const val MI_NOMBRE: String = "nombre"
        private const val MI_EDAD: String = "edad"

        fun newInstance(nombre: String, edad: Int) = SecondFragment().apply {
            arguments = bundleOf( MI_NOMBRE to nombre, MI_EDAD to edad)
        }
    }
}