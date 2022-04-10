package viktor.khlebnikov.gb.gb_endless_list.network.api

import viktor.khlebnikov.gb.gb_endless_list.network.retrofit.RetrofitNetwork

class ApiHolder {
    val api: IDataSource by lazy {
        RetrofitNetwork().getService("https://www.reddit.com/").create(IDataSource::class.java)
    }
}