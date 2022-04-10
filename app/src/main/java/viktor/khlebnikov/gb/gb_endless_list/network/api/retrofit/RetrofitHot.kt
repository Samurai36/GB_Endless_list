package viktor.khlebnikov.gb.gb_endless_list.network.api.retrofit

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import viktor.khlebnikov.gb.gb_endless_list.network.api.IDataSource
import viktor.khlebnikov.gb.gb_endless_list.network.api.hot.Hot

class RetrofitHot(private val api: IDataSource) : IHot {
    override fun getHot(): Single<Hot> = api.getHot().subscribeOn(Schedulers.io())
}