package e.bolsadeideas.fanatic.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import e.bolsadeideas.fanatic.data.model.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun movieDao(): IMovieDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            return INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "movie-table"
            ).build()
        }
    }
}