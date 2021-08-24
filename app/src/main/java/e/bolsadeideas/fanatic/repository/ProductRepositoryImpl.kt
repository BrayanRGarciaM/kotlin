package e.bolsadeideas.fanatic.repository

import e.bolsadeideas.fanatic.data.model.MovieList
import e.bolsadeideas.fanatic.data.remote.RemoteMovieDataSource

class ProductRepositoryImpl(private val dataSourceRemote: RemoteMovieDataSource) : IProductRepository {
    override suspend fun getPopularMovies(): MovieList = dataSourceRemote.getPopularMovies()

    override suspend fun getTopRatedMovies(): MovieList = dataSourceRemote.getTopRatedMovies()

    override suspend fun getUpcomingMovies(): MovieList = dataSourceRemote.getUpcomingMovies()

}