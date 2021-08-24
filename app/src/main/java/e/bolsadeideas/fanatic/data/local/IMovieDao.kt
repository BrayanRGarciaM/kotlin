package e.bolsadeideas.fanatic.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import e.bolsadeideas.fanatic.data.model.MovieEntity

@Dao
interface IMovieDao {

    @Query("Select * from MovieEntity")
    suspend fun getAllMovies(): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovie(movie: MovieEntity)
}