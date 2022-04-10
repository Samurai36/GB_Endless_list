package viktor.khlebnikov.gb.gb_endless_list.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collectLatest
import viktor.khlebnikov.gb.gb_endless_list.database.AppDataBase
import viktor.khlebnikov.gb.gb_endless_list.database.HotDao
import viktor.khlebnikov.gb.gb_endless_list.databinding.FragmentListBinding
import viktor.khlebnikov.gb.gb_endless_list.network.api.ApiHolder
import viktor.khlebnikov.gb.gb_endless_list.network.api.hot.Child
import viktor.khlebnikov.gb.gb_endless_list.network.api.retrofit.RetrofitHot
import viktor.khlebnikov.gb.gb_endless_list.ui.paging.PagingAdapter
import viktor.khlebnikov.gb.gb_endless_list.ui.paging.PagingViewModel
import viktor.khlebnikov.gb.gb_endless_list.util.ChildToHotEntity

class FragmentList : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var db: HotDao
    private val scope = CoroutineScope(Dispatchers.IO)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = AppDataBase.instance.getHotDao()
        getHot()
    }

    private fun saveDataToDB(child: List<Child>): Job {
        return scope.launch(Dispatchers.Main) {
            db.insertAll(ChildToHotEntity.getHot(child))
            getData()
        }
    }

    private fun getData() {
        scope.launch(Dispatchers.Main) {
            renderData()
        }
    }

    private fun getHot() {
        RetrofitHot(ApiHolder().api).getHot()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ hot ->
                hot.data?.children?.let {
                    saveDataToDB(it)
                }

            }, {
                Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
            })
    }

    private fun renderData() {
        val adapter = PagingAdapter()
        binding.list.adapter = adapter

        lifecycleScope.launch {
            PagingViewModel(db).allCheeses.collectLatest {adapter.submitData(it) }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentList()
    }
}