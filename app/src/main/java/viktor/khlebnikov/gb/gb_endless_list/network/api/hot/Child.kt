package viktor.khlebnikov.gb.gb_endless_list.network.api.hot

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Child {

    @SerializedName("data")
    @Expose
    var data: DataMain? = null
}