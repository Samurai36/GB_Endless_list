package viktor.khlebnikov.gb.gb_endless_list.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class HotEntity(

    @PrimaryKey(autoGenerate = true) val id: Int,
    @field:ColumnInfo(name = "content")
    var content: String,
    @field:ColumnInfo(name = "star_rate")
    var starRate: String,
    @field:ColumnInfo(name = "comment_size")
    var comment_size: String?

)
