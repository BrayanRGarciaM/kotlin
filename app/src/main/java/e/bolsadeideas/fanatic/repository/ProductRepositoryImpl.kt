package e.bolsadeideas.fanatic.repository

import e.bolsadeideas.fanatic.data.model.MovieList
import e.bolsadeideas.fanatic.data.remote.MovieDataSource

class ProductRepositoryImpl(private val dataSource: MovieDataSource) : IProductRepository {
    override suspend fun getPopularMovies(): MovieList = dataSource.getPopularMovies()

    override suspend fun getTopRatedMovies(): MovieList = dataSource.getTopRatedMovies()

    override suspend fun getUpcomingMovies(): MovieList = dataSource.getUpcomingMovies()

}