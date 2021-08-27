package e.bolsadeideas.fanatic.repository

import e.bolsadeideas.fanatic.core.InternetCheck
import e.bolsadeideas.fanatic.data.local.LocalMovieDataSource
import e.bolsadeideas.fanatic.data.model.MovieList
import e.bolsadeideas.fanatic.data.model.toMovieEntity
import e.bolsadeideas.fanatic.data.remote.RemoteMovieDataSource
import e.bolsadeideas.fanatic.utils.Constants

class ProductRepositoryImpl(
    private val dataSourceRemote: RemoteMovieDataSource,
    private val dataSourceLocal: LocalMovieDataSource
) : IProductRepository {
    override suspend fun getPopularMovies(): MovieList {
        if(InternetCheck.isNetworkAvailable()) {
            dataSourceRemote.getPopularMovies().results.forEach { movie ->
                dataSourceLocal.saveMovie(movie.toMovieEntity(Constants.POPULAR))
            }
        }
        return dataSourceLocal.getPopularMovies()
    }

    override suspend fun getTopRatedMovies(): MovieList {
        if(InternetCheck.isNetworkAvailable()) {
            dataSourceRemote.getTopRatedMovies().results.forEach { movie ->
                dataSourceLocal.saveMovie(movie.toMovieEntity(Constants.TOP_RATED))
            }
        }
        return dataSourceLocal.getTopRatedMovies()
    }

    override suspend fun getUpcomingMovies(): MovieList {
        if(InternetCheck.isNetworkAvailable()) {
            dataSourceRemote.getUpcomingMovies().results.forEach { movie ->
                dataSourceLocal.saveMovie(movie.toMovieEntity(Constants.UPCOMING))
            }
        }
        return dataSourceLocal.getUpcomingMovies()
    }

}