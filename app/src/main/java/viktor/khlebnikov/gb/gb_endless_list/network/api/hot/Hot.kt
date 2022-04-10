package viktor.khlebnikov.gb.gb_endless_list.network.api.hot

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Hot {
    @SerializedName("data")
    @Expose
    var data: DataChild? = null
}