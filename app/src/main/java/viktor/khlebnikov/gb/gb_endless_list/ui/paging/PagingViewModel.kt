package viktor.khlebnikov.gb.gb_endless_list.ui.paging

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import viktor.khlebnikov.gb.gb_endless_list.database.HotDao
import viktor.khlebnikov.gb.gb_endless_list.database.HotEntity

class PagingViewModel(private val dao: HotDao) : ViewModel() {

    private val DEFAULT_PAGE_SIZE = 10

    val allCheeses: Flow<PagingData<HotEntity>> = Pager(
        config = PagingConfig(
            pageSize = DEFAULT_PAGE_SIZE,
            enablePlaceholders = true,
            maxSize = dao.getCount()
        )
    ) {
        dao.getPaging()
    }.flow.cachedIn(CoroutineScope(Dispatchers.IO))

}
