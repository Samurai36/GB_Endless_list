package viktor.khlebnikov.gb.gb_endless_list.ui.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import viktor.khlebnikov.gb.gb_endless_list.database.HotEntity
import viktor.khlebnikov.gb.gb_endless_list.R

class PagingAdapter : PagingDataAdapter<HotEntity, PagingAdapter.PagingViewHolder>(diffCallback) {
    override fun onBindViewHolder(holder: PagingViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingViewHolder {
        return PagingViewHolder(parent)
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<HotEntity>() {

            override fun areItemsTheSame(oldItem: HotEntity, newItem: HotEntity): Boolean {
                return oldItem.content == newItem.content
            }

            override fun areContentsTheSame(oldItem: HotEntity, newItem: HotEntity): Boolean {
                return oldItem.starRate == newItem.starRate
                        && oldItem.comment_size == newItem.comment_size
            }
        }
    }

    inner class PagingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.fragment_list_item, parent, false)
    ) {
        private val nameView = itemView.findViewById<TextView>(R.id.title)
        private val starNum = itemView.findViewById<TextView>(R.id.image_star_rate)
        private val commentSize = itemView.findViewById<TextView>(R.id.comment_size)

        fun bindTo(item: HotEntity?) {

            nameView.text = item?.content
            starNum.text = item?.starRate
            commentSize.text = item?.comment_size
        }
    }
}


