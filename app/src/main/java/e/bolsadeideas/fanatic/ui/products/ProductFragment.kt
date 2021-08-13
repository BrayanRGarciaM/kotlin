package e.bolsadeideas.fanatic.ui.products

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import e.bolsadeideas.fanatic.R
import e.bolsadeideas.fanatic.core.Resource
import e.bolsadeideas.fanatic.data.remote.MovieDataSource
import e.bolsadeideas.fanatic.databinding.FragmentProductBinding
import e.bolsadeideas.fanatic.presentation.ProductViewModel
import e.bolsadeideas.fanatic.presentation.ProductViewModelFactory
import e.bolsadeideas.fanatic.repository.IProductRepository
import e.bolsadeideas.fanatic.repository.ProductRepositoryImpl
import e.bolsadeideas.fanatic.repository.RetrofitClient

class ProductFragment : Fragment(R.layout.fragment_product) {

    private lateinit var binding: FragmentProductBinding
    private val viewModel by viewModels<ProductViewModel> { ProductViewModelFactory(ProductRepositoryImpl(
        MovieDataSource(RetrofitClient.webService)
    )) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentProductBinding.bind(view)

        subscribeViewModel()
    }

    fun subscribeViewModel(){
        viewModel.fetchMainViewMovies().observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is Resource.Loading -> { Log.d("LiveData", "Loading...")}
                is Resource.Failure<*> -> {Log.d("LiveData", "Failure! ${result.exception}")}
                is Resource.Success -> {Log.d("LiveData", "Success Upcoming Movies: ${result.data.first} \n \n Popular Movies: ${result.data.second} \n \n Top Rated Movies: ${result.data.third}")}
            }
        })

//        viewModel.fetchPopularMovies().observe(viewLifecycleOwner, Observer { result ->
//            when(result){
//                is Resource.Loading -> { Log.d("LiveData", "Loading...")}
//                is Resource.Failure<*> -> {Log.d("LiveData", "Failure! ${result.exception}")}
//                is Resource.Success -> {Log.d("LiveData", "Success ${result.data}")}
//            }
//        })
//
//        viewModel.fetchTopRatedMovies().observe(viewLifecycleOwner, Observer { result ->
//            when(result){
//                is Resource.Loading -> { Log.d("LiveData", "Loading...")}
//                is Resource.Failure<*> -> {Log.d("LiveData", "Failure! ${result.exception}")}
//                is Resource.Success -> {Log.d("LiveData", "Success ${result.data}")}
//            }
//        })
    }

}