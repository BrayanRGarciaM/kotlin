package e.bolsadeideas.fanatic.learningfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import e.bolsadeideas.fanatic.R


class FirstFragment : Fragment(R.layout.fragment_first) {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtViewInfo = view.findViewById<TextView>(R.id.txtViewFragm1Info)
        val button = view.findViewById<Button>(R.id.btnNavegarSegFragm)

//        setFragmentResultListener("requestKeyFragment"){ _ , bundle ->
//            val result = bundle.getString("bundleKey")
//            txtViewInfo.text = result
//        }

        button.setOnClickListener {
//            Fragment communication using Fragment Manager
//            requireActivity().supportFragmentManager.commit {
//                replace(R.id.fragment_container_view, SecondFragment.newInstance("Brayan", 23))
//                addToBackStack("FirstFragment")
//            }

//            Using safe arguments
//            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment("Brayan", 28)
            viewModel.setUsuario(Usuario("Carlos", 38))

            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)

//            Using Navigation
//            findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundleOf("nombre" to "Brayan", "edad" to 23))
        }

        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<Usuario>("usuario")?.observe(
            viewLifecycleOwner) { user ->
            txtViewInfo.text = user.nombre + " " + user.edad.toString()
        }

    }
}