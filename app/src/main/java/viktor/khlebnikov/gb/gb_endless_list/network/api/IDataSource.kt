package viktor.khlebnikov.gb.gb_endless_list.network.api

import io.reactivex.rxjava3.core.Single
import viktor.khlebnikov.gb.gb_endless_list.network.api.hot.Hot
import retrofit2.http.GET

interface IDataSource {

    @GET("r/aww/hot.json")
    fun getHot(): Single<Hot>

}