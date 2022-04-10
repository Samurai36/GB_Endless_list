package viktor.khlebnikov.gb.gb_endless_list.database

import android.app.Application
import androidx.room.Room

class AppDataBase : Application() {

    private val DATA_BASE_NAME = "database_endless_list"

    private lateinit var db: HotDataBase

    override fun onCreate() {
        super.onCreate()
        instance = this
        db = Room.databaseBuilder(
            applicationContext,
            HotDataBase::class.java,
            DATA_BASE_NAME
        )
            .allowMainThreadQueries()
            .build()
    }

    fun getHotDao() = db.getHotDao()

    companion object {
        lateinit var instance: AppDataBase
    }
}