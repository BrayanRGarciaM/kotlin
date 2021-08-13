package e.bolsadeideas.fanatic.ui.productsdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import e.bolsadeideas.fanatic.R
import e.bolsadeideas.fanatic.databinding.FragmentCardBinding

class CardFragment : Fragment(R.layout.fragment_card) {

    private lateinit var binding: FragmentCardBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCardBinding.bind(view)
    }

}