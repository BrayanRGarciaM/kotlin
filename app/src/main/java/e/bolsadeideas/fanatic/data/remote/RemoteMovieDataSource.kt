package e.bolsadeideas.fanatic.data.remote

import e.bolsadeideas.fanatic.data.model.MovieList
import e.bolsadeideas.fanatic.repository.WebService
import e.bolsadeideas.fanatic.utils.Constants

class RemoteMovieDataSource (private val webService: WebService){

    suspend fun getUpcomingMovies(): MovieList{
        return webService.getUpcomingMovies(Constants.API_KEY)
    }

    suspend fun getTopRatedMovies(): MovieList{
        return webService.getTopRatedMovies(Constants.API_KEY)
    }

    suspend fun getPopularMovies(): MovieList{
        return webService.getPopularMovies(Constants.API_KEY)
    }
}