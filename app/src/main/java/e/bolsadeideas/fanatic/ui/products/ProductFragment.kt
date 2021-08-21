package e.bolsadeideas.fanatic.ui.products

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ConcatAdapter
import e.bolsadeideas.fanatic.R
import e.bolsadeideas.fanatic.core.Resource
import e.bolsadeideas.fanatic.data.model.Movie
import e.bolsadeideas.fanatic.data.remote.MovieDataSource
import e.bolsadeideas.fanatic.databinding.FragmentProductBinding
import e.bolsadeideas.fanatic.presentation.ProductViewModel
import e.bolsadeideas.fanatic.presentation.ProductViewModelFactory
import e.bolsadeideas.fanatic.repository.IProductRepository
import e.bolsadeideas.fanatic.repository.ProductRepositoryImpl
import e.bolsadeideas.fanatic.repository.RetrofitClient
import e.bolsadeideas.fanatic.ui.products.adapters.PopularConcatAdapter
import e.bolsadeideas.fanatic.ui.products.adapters.ProductAdapter
import e.bolsadeideas.fanatic.ui.products.adapters.concat.TopRatedConcatAdapter
import e.bolsadeideas.fanatic.ui.products.adapters.concat.UpcomingConcatAdapter

class ProductFragment : Fragment(R.layout.fragment_product), ProductAdapter.OnMovieClickListener {

    private lateinit var binding: FragmentProductBinding
    private lateinit var concatAdapter: ConcatAdapter
    private val viewModel by viewModels<ProductViewModel> { ProductViewModelFactory(ProductRepositoryImpl(
        MovieDataSource(RetrofitClient.webService)
    )) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentProductBinding.bind(view)
        concatAdapter = ConcatAdapter()

        subscribeViewModel()
    }

    fun subscribeViewModel(){
        viewModel.fetchMainViewMovies().observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Failure<*> -> {
                    binding.progressBar.visibility = View.GONE
                    Log.d("LiveData", "Failure! ${result.exception}")
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    concatAdapter.apply {
                        addAdapter(0, UpcomingConcatAdapter(ProductAdapter(result.data.first.results,this@ProductFragment)))
                        addAdapter(1, PopularConcatAdapter(ProductAdapter(result.data.second.results, this@ProductFragment)))
                        addAdapter(2, TopRatedConcatAdapter(ProductAdapter(result.data.third.results, this@ProductFragment)))
                    }
                    binding.rvProducts.adapter = concatAdapter
                }
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

    override fun onMovieClick(movie: Movie) {
        Log.d("MOVIE", "${movie.title}")
    }

}