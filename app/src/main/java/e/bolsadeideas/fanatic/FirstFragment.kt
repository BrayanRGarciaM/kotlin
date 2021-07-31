package e.bolsadeideas.fanatic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController


class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtViewInfo = view.findViewById<TextView>(R.id.txtViewFragm1Info)
        val button = view.findViewById<Button>(R.id.btnNavegarSegFragm)

        setFragmentResultListener("requestKeyFragment"){ requestKey, bundle ->
            val result = bundle.getString("bundleKey")
            txtViewInfo.text = result
        }

        button.setOnClickListener {
//            Fragment communication using Fragment Manager
//            requireActivity().supportFragmentManager.commit {
//                replace(R.id.fragment_container_view, SecondFragment.newInstance("Brayan", 23))
//                addToBackStack("FirstFragment")
//            }

//            Using safe arguments
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment("Brayan", 28)
            findNavController().navigate(action)

//            Using Navigation
//            findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundleOf("nombre" to "Brayan", "edad" to 23))
        }

    }
}