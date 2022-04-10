package viktor.khlebnikov.gb.gb_endless_list.util

import viktor.khlebnikov.gb.gb_endless_list.database.HotEntity
import viktor.khlebnikov.gb.gb_endless_list.network.api.hot.Child

class ChildToHotEntity {

    companion object {
        fun getHot(child: List<Child>): List<HotEntity> {
            val hotEntity = arrayListOf<HotEntity>()

            child.forEach {
                val content: String = it.data?.title ?: "No info"
                val starRate: String = (it.data?.numCrossposts ?: "0").toString()
                val commentSize: String = (it.data?.numComments ?: "0").toString()
                val hot = HotEntity(0,content, starRate, commentSize)
                hotEntity.add(hot)
            }

            return hotEntity
        }
    }
}