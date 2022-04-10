package viktor.khlebnikov.gb.gb_endless_list.network.api.retrofit

import io.reactivex.rxjava3.core.Single
import viktor.khlebnikov.gb.gb_endless_list.network.api.hot.Hot

interface IHot {
    fun getHot(): Single<Hot>
}