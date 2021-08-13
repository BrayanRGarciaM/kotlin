package e.bolsadeideas.fanatic.repository

import e.bolsadeideas.fanatic.data.model.MovieList

interface IProductRepository {
    suspend fun getPopularMovies(): MovieList
    suspend fun getTopRatedMovies(): MovieList
    suspend fun getUpcomingMovies(): MovieList
}