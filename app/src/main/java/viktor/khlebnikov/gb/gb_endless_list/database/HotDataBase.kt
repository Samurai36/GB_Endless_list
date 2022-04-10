package viktor.khlebnikov.gb.gb_endless_list.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [HotEntity::class], version = 1, exportSchema = false)
abstract class HotDataBase : RoomDatabase() {

    abstract fun getHotDao(): HotDao
}
