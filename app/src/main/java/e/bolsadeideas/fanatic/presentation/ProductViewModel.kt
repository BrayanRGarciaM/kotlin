package e.bolsadeideas.fanatic.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import e.bolsadeideas.fanatic.core.Resource
import e.bolsadeideas.fanatic.repository.IProductRepository
import kotlinx.coroutines.Dispatchers

class ProductViewModel(private val repo: IProductRepository): ViewModel() {
    fun fetchUppcomingMovies() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())

        try {
            emit(Resource.Success(repo.getUpcomingMovies()))
        }catch (e: Exception){
            emit(Resource.Failure<Exception>(e))

        }
    }
}

class ProductViewModelFactory(private val repo: IProductRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = modelClass.getConstructor(IProductRepository::class.java).newInstance(repo)

}