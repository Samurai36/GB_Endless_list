package viktor.khlebnikov.gb.gb_endless_list.network.api.hot

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DataMain {

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("num_comments")
    @Expose
    var numComments: Long? = null

    @SerializedName("num_crossposts")
    @Expose
    var numCrossposts: Long? = null
}