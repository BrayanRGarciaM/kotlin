package e.bolsadeideas.fanatic.data.local

import e.bolsadeideas.fanatic.data.model.MovieEntity
import e.bolsadeideas.fanatic.data.model.MovieList
import e.bolsadeideas.fanatic.data.model.toMovieList

class LocalMovieDataSource(private val movieDao: IMovieDao) {
    suspend fun getUpcomingMovies(): MovieList {
        return movieDao.getAllMovies().filter { it.movie_type == "upcoming" }.toMovieList()
    }

    suspend fun getTopRatedMovies(): MovieList {
        return movieDao.getAllMovies().filter { it.movie_type == "toprated" }.toMovieList()
    }

    suspend fun getPopularMovies(): MovieList {
        return movieDao.getAllMovies().filter { it.movie_type == "popular" }.toMovieList()
    }

    suspend fun saveMovie(movie: MovieEntity){
        movieDao.saveMovie(movie)
    }
}