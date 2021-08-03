package e.bolsadeideas.fanatic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import e.bolsadeideas.fanatic.databinding.FragmentProductBinding

class ProductFragment : Fragment(R.layout.fragment_product) {

    private lateinit var binding: FragmentProductBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentProductBinding.bind(view)
    }

}