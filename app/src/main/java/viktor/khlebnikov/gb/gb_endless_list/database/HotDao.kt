package viktor.khlebnikov.gb.gb_endless_list.database

import androidx.paging.PagingSource
import androidx.room.*

@Dao
interface HotDao {

    @Query("SELECT * FROM HotEntity")
    suspend fun all(): List<HotEntity>

    @Query("SELECT * FROM HotEntity")
    fun getPaging(): PagingSource<Int, HotEntity>

    @Query("SELECT COUNT(*) FROM HotEntity")
    fun getCount(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entity: HotEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(entities: List<HotEntity>)

    @Update
    suspend fun update(entity: HotEntity)

    @Delete
    suspend fun delete(entity: HotEntity)
}
