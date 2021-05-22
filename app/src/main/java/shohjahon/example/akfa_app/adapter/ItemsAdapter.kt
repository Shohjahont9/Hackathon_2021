package shohjahon.example.akfa_app.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import shohjahon.example.akfa_app.databinding.ItemExpiredBinding
import shohjahon.example.akfa_app.databinding.ItemSawBinding
import shohjahon.example.akfa_app.network.response.expiredResponse.DataExperid
import shohjahon.example.akfa_app.network.response.items.DataItems
import kotlin.collections.ArrayList


@SuppressLint("SetTextI18n")
class ItemsAdapter(
    private val listener: CardAdapterListener
) : ListAdapter<DataItems, ItemsAdapter.CardsViewHolder>(
    DIFF_JOB_CALLBACK
) {

    private lateinit var fullDataList: ArrayList<DataItems>


    companion object {
        val DIFF_JOB_CALLBACK = object : DiffUtil.ItemCallback<DataItems>() {
            override fun areItemsTheSame(
                oldItem: DataItems,
                newItem: DataItems
            ) = newItem.articul == oldItem.articul

            override fun areContentsTheSame(
                oldItem: DataItems,
                newItem: DataItems
            ) = newItem.articul == oldItem.articul

        }
    }

    override fun getItemId(position: Int) = position.toLong()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CardsViewHolder(
            ItemSawBinding.inflate(LayoutInflater.from(parent.context),parent,false),
            listener
        )

    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {
        holder.setIsRecyclable(true)
        holder.bind()
    }

    fun submitDataList(list: List<DataItems>) {
        submitList(list)
        println("list submit")
        fullDataList = ArrayList(list)
    }

    inner class CardsViewHolder
    constructor(
        private val binding: ItemSawBinding,
        private val listener: CardAdapterListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val data = getItem(adapterPosition)
            with(binding) {

                tvName.text = data.type

                tvArticul.text = data.articul

                val progress = ((data.life_time!! - data.remained_hours!!.toInt())/(data.life_time/100)).toString()
                val progressHor = ((data.initial_details!! - data.remained_details!!.toInt())/(data.initial_details/100)).toString()

                tvHours.text = "${ data.remained_hours }/${data.life_time}"

                tvPercent.text = "$progress%"

                tvItems.text = "${ data.remained_details}/${data.initial_details}"

                circularProgressBar.progress = progress.toFloat()

                progressBar1.progress = progressHor.toInt()

                root.setOnClickListener {
                    if (adapterPosition != RecyclerView.NO_POSITION)
                        listener.onItemClick(adapterPosition, data)
                }
            }
        }
    }


    interface CardAdapterListener {
        fun onItemClick(position: Int, data: DataItems)
    }
}

