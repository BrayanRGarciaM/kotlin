package e.bolsadeideas.fanatic.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Movie(
    val id: Int = -1,
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val original_title: String = "",
    val original_language: String = "",
    val overview: String = "",
    val popularity: Double = -1.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = -1.0,
    val vote_count: Int = -1,
    val movie_type: String = ""
)

data class MovieList(val results: List<Movie> = listOf())

@Entity
data class MovieEntity(
    @PrimaryKey
    val id: Int = -1,
    @ColumnInfo
    val adult: Boolean = false,
    @ColumnInfo
    val backdrop_path: String = "",
    @ColumnInfo
    val original_title: String = "",
    @ColumnInfo
    val original_language: String = "",
    @ColumnInfo
    val overview: String = "",
    @ColumnInfo
    val popularity: Double = -1.0,
    @ColumnInfo
    val poster_path: String = "",
    @ColumnInfo
    val release_date: String = "",
    @ColumnInfo
    val title: String = "",
    @ColumnInfo
    val video: Boolean = false,
    @ColumnInfo
    val vote_average: Double = -1.0,
    @ColumnInfo
    val vote_count: Int = -1,
    @ColumnInfo
    val movie_type: String = ""
)

//Extension Functions
fun List<MovieEntity>.toMovieList(): MovieList{
    val movies = mutableListOf<Movie>()
    forEach { movieEntity ->
          movies.add(movieEntity.toMovie())
    }
    return MovieList(movies)
}

fun MovieEntity.toMovie(): Movie{
    return Movie(
        this.id,
        this.adult,
        this.backdrop_path,
        this.original_title,
        this.original_language,
        this.overview,
        this.popularity,
        this.poster_path,
        this.release_date,
        this.title,
        this.video,
        this.vote_average,
        this.vote_count,
        this.movie_type,
    )
}