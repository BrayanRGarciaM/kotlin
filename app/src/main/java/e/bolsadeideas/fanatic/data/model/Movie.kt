package e.bolsadeideas.fanatic.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Movie(
    val id: Int = -1,
    val adult: Boolean = false,
    val genre_ids: List<Int> = listOf(),
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
    val vote_count: Int = -1
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
    val vote_count: Int = -1
)